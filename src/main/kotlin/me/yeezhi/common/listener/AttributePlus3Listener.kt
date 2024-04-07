package me.yeezhi.common.listener

import me.yeezhi.common.event.AttributeUpdateEvent
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.serverct.ersha.api.AttributeAPI
import org.serverct.ersha.api.event.AttrUpdateAttributeEvent
import taboolib.common.platform.Ghost
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.submit
import taboolib.platform.util.bukkitPlugin

object AttributePlus3Listener {
    /**
     * 玩家属性更新时生效类库的属性
     * 适用AP3.X
     *
     * @param event AP玩家属性更新事件
     */
    @Ghost
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onAttrUpdateAttributeEvent(event: AttrUpdateAttributeEvent.After) {
        submit {
            val entity: Entity = event.attributeData.getEntity() as? Player ?: return@submit
            val player = entity as Player
            val attributeUpdateEvent = AttributeUpdateEvent(player)
            attributeUpdateEvent.call()
            AttributeAPI.addSourceAttribute(event.attributeData, bukkitPlugin.name, attributeUpdateEvent.getLores())
        }
    }
}