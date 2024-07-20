package me.yeezhi.common.util

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import taboolib.platform.util.getEmptySlot
import taboolib.platform.util.isAir

/**
 * Inventory 工具
 */
object InventoryUtil {

    /**
     * 获取 Inventory 可存储多少指定物品
     *
     * @param itemStack 物品
     * @return 可存储指定物品数量
     */
    fun Player.getInventoryVolume(itemStack: ItemStack): Int {
        if (itemStack.isAir) {
            return 0
        }
        var volume = 0
        for (content in this.inventory.storageContents) {
            if (content.isAir) {
                continue
            }
            if (!content.isSimilar(itemStack)) {
                continue
            }
            if (content.amount >= content.maxStackSize) {
                continue
            }
            volume += content.maxStackSize - content.amount
        }
        volume += itemStack.type.maxStackSize * this.getEmptySlot(false)
        return volume
    }
}
