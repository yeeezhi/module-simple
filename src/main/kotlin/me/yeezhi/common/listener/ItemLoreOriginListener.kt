package me.yeezhi.common.listener

import com.mchim.ItemLoreOrigin.Event.ItemLoreDamageEvent
import com.mchim.ItemLoreOrigin.Event.ItemLoreStatusEvent
import com.mchim.ItemLoreOrigin.Event.ItemLoreTickEvent
import com.mchim.ItemLoreOrigin.ItemLoreData.ItemLoreManager
import me.yeezhi.common.api.AttributeAPI.getAttributeItems
import org.bukkit.entity.Player
import taboolib.common.platform.Ghost
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent

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
        updateAttribute(player, event.manager)
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
        updateAttribute(player, event.damagerManager)
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
        updateAttribute(player, event.manager)
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
        val ilm = managers[0]
        player.getAttributeItems().forEach { itemStack -> ilm.initLoreData(itemStack) }
    }
}
