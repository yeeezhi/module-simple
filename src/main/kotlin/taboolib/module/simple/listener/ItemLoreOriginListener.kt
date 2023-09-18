package taboolib.module.simple.listener

import com.google.common.collect.Lists
import com.mchim.ItemLoreOrigin.Config.Settings
import com.mchim.ItemLoreOrigin.Event.ItemLoreDamageEvent
import com.mchim.ItemLoreOrigin.Event.ItemLoreStatusEvent
import com.mchim.ItemLoreOrigin.Event.ItemLoreTickEvent
import com.mchim.ItemLoreOrigin.ItemLoreData.ItemLoreManager
import com.mchim.ItemLoreOrigin.ItemLoreData.Origin.LoreOrigin
import net.md_5.bungee.api.ChatColor
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import taboolib.common.platform.Ghost
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent
import taboolib.module.simple.event.AttributeUpdateEvent

object ItemLoreOriginListener {
    /**
     * 玩家查看Stats时生效类库的属性
     *
     * @param event ILO的玩家查看Stats事件
     */
    @Ghost
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onItemLoreStatusEvent(event: ItemLoreStatusEvent) {
        if (event.entity !is Player) {
            return
        }
        val player: Player = event.entity
        val managers: MutableList<ItemLoreManager> = event.manager
        updateAttribute(player, managers)
    }

    /**
     * 使用Item攻击时生效类库的属性
     *
     * @param event ILO的使用Item攻击事件
     */
    @Ghost
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onItemLoreDamageEvent(event: ItemLoreDamageEvent) {
        if (event.damager !is Player) {
            return
        }
        val player = event.damager as Player
        val managers: MutableList<ItemLoreManager> = event.damagerManager ?: return
        updateAttribute(player, managers)
    }

    /**
     * 使用Item攻击时生效类库的属性
     *
     * @param event ILO的Tick事件,触发频率: 一秒一次
     */
    @Ghost
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onItemLoreTickEvent(event: ItemLoreTickEvent) {
        val player: Player = event.entity
        val managers: MutableList<ItemLoreManager> = event.manager
        updateAttribute(player, managers)
    }

    /**
     * 生效玩家属性
     *
     * @param player   玩家
     * @param managers 属性管理
     */
    private fun updateAttribute(player: Player, managers: MutableList<ItemLoreManager>?) {
        if (managers == null) {
            return
        }
        if (managers.size == 0) {
            managers.add(ItemLoreManager(player))
        }
        val attributeUpdateEvent = AttributeUpdateEvent(player)
        attributeUpdateEvent.call()
        handleAttribute(player, managers, attributeUpdateEvent.playerLores)
        println(attributeUpdateEvent.playerLores)
    }

    /**
     * 处理ilo属性
     * 一般在ItemLoreStatusEvent,ItemLoreDamageEvent,ItemLoreTickEvent触发时使用
     *
     * @param player    玩家
     * @param managers  事件中获取
     * @param loreList 生效的属性Lore
     */
    private fun handleAttribute(player: Player, managers: List<ItemLoreManager>, loreList: List<String>) {
        val ilm = managers[0]
        ilm.loreData.addAll(getLoreOriginList(player, loreList))
    }

    /**
     * 通过Lore获取属性
     *
     * @param player 玩家
     * @param loreList   Lore
     * @return 玩家属性
     */
    private fun getLoreOriginList(player: Player, loreList: List<String>): List<LoreOrigin> {
        val lists: MutableList<LoreOrigin> = Lists.newArrayList()
        if (loreList.isEmpty()) {
            return lists
        }
        for (str in loreList) {
            val lore = ChatColor.stripColor(str)
            var loreType: String? = null
            for (type in Settings.I.loreType.keys) {
                val list = Settings.I.loreType[type]!!
                for (ss in list) {
                    if (lore.contains(ss!!)) {
                        loreType = type
                        break
                    }
                }
            }
            if (loreType != null && LoreOrigin.originMap.containsKey(loreType)) {
                try {
                    val lo = LoreOrigin.originMap[loreType]!!.getConstructor(
                        *arrayOf<Class<*>>(
                            LivingEntity::class.java
                        )
                    ).newInstance(*arrayOf<Any?>(player))
                    lo.init(lore)
                    if (lo.name != null) {
                        lists.add(lo)
                    }
                } catch (var12: Exception) {
                    var12.printStackTrace()
                }
            }
        }
        return lists
    }
}
