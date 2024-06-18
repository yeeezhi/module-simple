package me.yeezhi.common.listener

import me.yeezhi.common.api.AttributeAPI.getAttributeLores
import org.bukkit.entity.Player
import org.serverct.ersha.jd.AttributeAPI
import org.serverct.ersha.jd.event.AttrAttributeUpdateEvent
import taboolib.common.platform.Ghost
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent
import taboolib.platform.util.bukkitPlugin

object AttributePlus2Listener {
    /**
     * 玩家属性更新时生效类库的属性
     * 适用AP2.X
     *
     * @param event AP玩家属性更新事件
     */
    @Ghost
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onAttrAttributeUpdateEvent(event: AttrAttributeUpdateEvent) {
        if (event.entity !is Player) {
            return
        }
        val player = event.entity as Player
        AttributeAPI.addAttribute(player, bukkitPlugin.name, player.getAttributeLores())

    }
}