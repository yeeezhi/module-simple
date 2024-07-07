package me.yeezhi.common.util

import org.bukkit.inventory.ItemStack
import taboolib.platform.util.isAir
import java.util.*

/**
 * 物品工具
 */
object ItemUtil {

    /**
     * 合并物品数量
     * 将不同堆里面的物品合并数量
     *
     * @param itemStacks 物品列表
     * @return 合并后的物品列表
     */

    fun List<ItemStack>.arrange(): MutableList<ItemStack> {
        val list: MutableList<ItemStack> = ArrayList()
        this.forEach f1@{
            if (it.isAir) {
                return@f1
            }
            val itemStack = it.clone()
            for (itemStack1 in list) {
                if (itemStack.isSimilar(itemStack1)) {
                    itemStack1.amount += itemStack.amount
                    return@f1
                }
                list.add(itemStack)
            }
        }
        return list
    }

}