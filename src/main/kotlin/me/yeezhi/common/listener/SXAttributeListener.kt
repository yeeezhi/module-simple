package me.yeezhi.common.listener

import github.saukiya.sxattribute.SXAttribute
import github.saukiya.sxattribute.event.SXLoadItemDataEvent
import me.yeezhi.common.api.AttributeAPI.getAttributeLores
import org.bukkit.entity.Player
import taboolib.common.platform.Ghost
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent

object SXAttributeListener {
    /**
     * 玩家物品载入时生效类库属性
     * 适用SX2.X
     *
     * @param event SX的物品载入属性事件
     */
    @Ghost
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onSXLoadItemDataEvent(event: SXLoadItemDataEvent) {
        if (event.entity !is Player) {
            return
        }
        val player = event.entity as Player
        val sxAttributeData = SXAttribute.getApi().getLoreData(player, null, player.getAttributeLores())
        SXAttribute.getApi().setEntityAPIData(SXAttributeListener::class.java, player.uniqueId, sxAttributeData)
    }
}
