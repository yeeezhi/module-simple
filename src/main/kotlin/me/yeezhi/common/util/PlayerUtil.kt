package me.yeezhi.common.util

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import taboolib.platform.util.giveItem
import taboolib.platform.util.isAir
import kotlin.math.min

/**
 * Player工具
 */
object PlayerUtil {
    /**
     * 给予玩家物品
     *
     * @param itemStack 物品
     */
    fun Player.addItem(itemStack: ItemStack?) {
        if (itemStack.isAir) {
            return
        }
        itemStack!!
        // 解决堆叠超过上限的问题
        var amount = itemStack.amount
        while (amount > 0) {
            val itemClone = itemStack.clone()
            itemClone.amount = min(amount, itemClone.maxStackSize)
            amount -= itemClone.amount
            giveItem(itemClone)
        }

    }

    /**
     * 给予玩家物品
     *
     * @param itemStack 物品
     * @param amount 数量
     */
    fun Player.addItem(itemStack: ItemStack?, amount: Int) {
        if (itemStack.isAir) {
            return
        }
        itemStack!!
        val itemClone = itemStack.clone()
        itemClone.amount = amount
        addItem(itemClone)
    }

    /**
     * 给予玩家物品
     *
     * @param list   物品列表
     */
    fun Player.addItem(list: MutableList<ItemStack>) {
        list.forEach { addItem(it) }
    }
}
