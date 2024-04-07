package me.yeezhi.common.listener

import ac.github.oa.api.OriginAttributeAPI
import ac.github.oa.api.event.entity.EntityLoadEquipmentEvent
import ac.github.oa.internal.core.attribute.AttributeData
import me.yeezhi.common.event.AttributeUpdateEvent
import org.bukkit.entity.Player
import taboolib.common.platform.Ghost
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent
import taboolib.platform.util.bukkitPlugin

object OriginAttributeListener {
    /**
     * 玩家物品载入时生效类库属性
     *
     * @param event OA实体属性生效
     */
    @Ghost
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onEntityLoadEquipmentEvent(event: EntityLoadEquipmentEvent) {
        if (event.livingEntity !is Player) {
            return
        }
        val player = event.livingEntity as Player
        val attributeUpdateEvent = AttributeUpdateEvent(player)
        attributeUpdateEvent.call()
        val attributeData: AttributeData = OriginAttributeAPI.loadList(attributeUpdateEvent.getLores())
        OriginAttributeAPI.setExtra(player.uniqueId, bukkitPlugin.name, attributeData)
        OriginAttributeAPI.callUpdate(player)
    }
}
