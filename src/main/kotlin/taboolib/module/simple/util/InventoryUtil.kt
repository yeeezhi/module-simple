package taboolib.module.simple.util

import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import taboolib.module.simple.util.ItemUtil.equalsItem
import taboolib.module.simple.util.ItemUtil.isItemStack

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
    fun Inventory.getInventoryVolume(itemStack: ItemStack?): Int {
        return if (itemStack == null || itemStack.type == Material.AIR) {
            -999
        } else itemStack.type.maxStackSize * this.getInventoryResidue()
    }

    /**
     * 获取 Inventory 剩余指定物品数量
     *
     * @param itemStack 物品
     * @return 剩余指定物品数量
     */
    fun Inventory.getItemStackCurrent(itemStack: ItemStack?): Int {
        var current = 0
        if (!isItemStack(itemStack)) {
            return current
        }
        for (content in this.storageContents) {
            if (!equalsItem(itemStack, content)) {
                continue
            }
            current += content.amount
        }
        return current
    }

    /**
     * 获取 Inventory 剩余空间格数

     */
    fun Inventory.getInventoryResidue(): Int {
        var residue = 0
        for (itemStack in this.storageContents) {
            if (itemStack == null || itemStack.type == Material.AIR) {
                residue++
            }
        }
        return residue
    }
}
