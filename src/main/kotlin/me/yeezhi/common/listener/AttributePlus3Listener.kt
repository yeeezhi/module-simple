package me.yeezhi.common.listener

import me.yeezhi.common.api.AttributeAPI.getAttributeLores
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.serverct.ersha.api.AttributeAPI
import org.serverct.ersha.api.event.AttrUpdateAttributeEvent
import taboolib.common.platform.Ghost
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent
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
        val entity: Entity = event.attributeData.getEntity() as? Player ?: return
        val player = entity as Player
        AttributeAPI.addSourceAttribute(event.attributeData, bukkitPlugin.name, player.getAttributeLores())
    }
}