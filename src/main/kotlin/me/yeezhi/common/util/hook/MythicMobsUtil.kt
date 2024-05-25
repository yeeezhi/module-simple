package me.yeezhi.common.util.hook

import io.lumine.xikage.mythicmobs.MythicMobs
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicReloadedEvent
import org.bukkit.inventory.ItemStack
import taboolib.common.platform.Ghost
import taboolib.common.platform.event.SubscribeEvent
import taboolib.platform.util.isAir

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
                val itemStack = MythicMobs.inst().itemManager.getItemStack(itemName)
                if (itemStack.isAir) {
                    map.remove(itemName)
                    continue
                }
                itemStack.amount = 1
                map[itemName] = itemStack
            } catch (ignored: Exception) {
                map.remove(itemName)
            }
        }
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
        val itemStack: ItemStack?
        try {
            if (map.containsKey(itemName)) {
                itemStack = map[itemName]!!.clone()
                itemStack.amount = amount
            } else {
                itemStack = MythicMobs.inst().itemManager.getItemStack(itemName)
                if (itemStack == null) {
                    return null
                }
                itemStack.amount = amount
                map[itemName] = itemStack
            }
            return itemStack
        } catch (exception: Exception) {
            throw RuntimeException("item acquisition failed", exception)
        }
    }
}
