package me.yeezhi.common.listener

import github.saukiya.sxattribute.SXAttribute
import github.saukiya.sxattribute.event.SXLoadItemDataEvent
import me.yeezhi.common.event.AttributeUpdateEvent
import org.bukkit.entity.Player
import taboolib.common.platform.Ghost
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.submit

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
        // 主线程执行
        submit {
            val player = event.entity as Player
            val attributeUpdateEvent = AttributeUpdateEvent(player)
            attributeUpdateEvent.call()
            val sxAttributeData = SXAttribute.getApi().getLoreData(player, null, attributeUpdateEvent.getLores())
            SXAttribute.getApi().setEntityAPIData(SXAttributeListener::class.java, player.uniqueId, sxAttributeData)
        }
    }
}
