package taboolib.module.simple.util.hook

import io.lumine.xikage.mythicmobs.MythicMobs
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicReloadedEvent
import org.bukkit.inventory.ItemStack
import taboolib.common.platform.Ghost
import taboolib.common.platform.event.SubscribeEvent

/**
 * MM物品库工具
 */
object MythicMobsUtil {
    private var map: MutableMap<String, ItemStack> = HashMap()

    @Ghost
    @SubscribeEvent
    fun listener(event: MythicReloadedEvent) {
        for (itemName in map.keys) {
            try {
                val itemStack = MythicMobs.inst().itemManager.getItemStack(itemName) ?: continue
                itemStack.amount = 1
                map[itemName] = itemStack
            } catch (ignored: java.lang.Exception) {
               map.remove(itemName)
            }
        }
        println(map)
    }

    /**
     * 根据MM物品名获取物品
     *
     * @param itemName 物品名
     * @return 物品
     */
    fun getItem(itemName: String): ItemStack? {
        return getItem(itemName, 1)
    }

    /**
     * 根据MM物品名获取指定数量的物品
     *
     * @param itemName 物品名
     * @param amount    物品数量
     * @return 物品
     */
    fun getItem(itemName: String, amount: Int): ItemStack? {
        var itemStack: ItemStack?
        if (map.containsKey(itemName)) {
            itemStack = map[itemName]!!.clone()
            itemStack.amount = amount
        } else {
            try {
                itemStack = MythicMobs.inst().itemManager.getItemStack(itemName)
                itemStack.amount = amount
            } catch (exception: Exception) {
                throw RuntimeException(exception)
            }
        }
        return itemStack
    }
}
