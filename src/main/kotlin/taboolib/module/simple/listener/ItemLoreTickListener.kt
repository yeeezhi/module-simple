package taboolib.module.simple.listener

import com.mchim.ItemLoreOrigin.Event.ItemLoreDamageEvent
import com.mchim.ItemLoreOrigin.Event.ItemLoreStatusEvent
import com.mchim.ItemLoreOrigin.Event.ItemLoreTickEvent
import com.mchim.ItemLoreOrigin.ItemLoreData.ItemLoreManager
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent
import taboolib.module.simple.event.AttributeUpdateEvent
import taboolib.module.simple.util.hook.ItemLoreOriginUtil

object ItemLoreTickListener {
    /**
     * 玩家查看Stats时生效类库的属性
     *
     * @param event ILO的玩家查看Stats事件
     */
    @EventHandler
    fun onItemLoreStatusEvent(event: ItemLoreStatusEvent) {
        val player: Player = event.entity
        val managers: MutableList<ItemLoreManager?> = event.getManager()
        updateAttribute(player, managers)
    }

    /**
     * 使用Item攻击时生效类库的属性
     *
     * @param event ILO的使用Item攻击事件
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onItemLoreDamageEvent(event: ItemLoreDamageEvent) {
        if (event.entity !is Player) {
            return
        }
        val player = event.entity as Player
        val managers: MutableList<ItemLoreManager?> = event.damagerManager
        updateAttribute(player, managers)
    }

    /**
     * 使用Item攻击时生效类库的属性
     *
     * @param event ILO的Tick事件,触发频率: 一秒一次
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onItemLoreTickEvent(event: ItemLoreTickEvent) {
        val player: Player = event.entity
        val managers: MutableList<ItemLoreManager?> = event.manager
        updateAttribute(player, managers)
    }

    /**
     * 生效玩家属性
     *
     * @param player   玩家
     * @param managers 属性管理
     */
    private fun updateAttribute(player: Player, managers: MutableList<ItemLoreManager?>?) {
        if (managers == null) {
            return
        }
        if (managers.size == 0) {
            managers.add(ItemLoreManager(player))
        }
        val attributeUpdateEvent = AttributeUpdateEvent(player)
        attributeUpdateEvent.call()
        ItemLoreOriginUtil.handleAttribute(player, managers, attributeUpdateEvent.playerLores)
    }
}
