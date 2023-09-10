package taboolib.module.simple.listener

import github.saukiya.sxattribute.event.SXLoadItemDataEvent
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent

object TestListener {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun test(event: SXLoadItemDataEvent) {
        println("SXLoadItemDataEvent 当前线程: " + Thread.currentThread().name)
    }
}
