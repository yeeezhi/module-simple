package me.yeezhi.common.util.hook

import ac.github.oa.internal.core.item.ItemPlant.build
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

/**
 * OriginAttribute物品库工具
 */
object OriginAttributeUtil {
    /**
     * 根据MM物品名获取物品
     *
     * @param player    玩家
     * @param itemName 物品名
     * @return 物品
     */
    fun getItem(player: Player, itemName: String): ItemStack? {
        return getItem(player, itemName, HashMap(), 1)
    }

    /**
     * 根据MM物品名获取物品
     *
     * @param player    玩家
     * @param itemName 物品名
     * @param map map
     * @return 物品
     */
    fun getItem(player: Player, itemName: String, map: MutableMap<String, String>): ItemStack? {
        return getItem(player, itemName, map, 1)
    }

    /**
     * 根据MM物品名获取指定数量的物品
     *
     * @param player    玩家
     * @param itemName 物品名
     * @param map map
     * @param amount    物品数量
     * @return 物品
     */
    fun getItem(player: Player, itemName: String, map: MutableMap<String, String>, amount: Int): ItemStack? {
        return try {
            val itemStack: ItemStack = build(player, itemName, map) ?: return null
            itemStack.amount = amount
            itemStack
        } catch (exception: Exception) {
            throw RuntimeException(exception)
        }
    }
}
