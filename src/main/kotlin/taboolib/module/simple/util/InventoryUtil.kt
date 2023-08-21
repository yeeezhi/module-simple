package taboolib.module.simple.util

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import taboolib.library.configuration.ConfigurationSection
import taboolib.library.xseries.XItemStack
import taboolib.module.simple.util.ItemUtil.equalsItem
import taboolib.module.simple.util.ItemUtil.getLore
import taboolib.module.simple.util.ItemUtil.setLore
import taboolib.platform.compat.replacePlaceholder
import taboolib.platform.util.isAir

/**
 * Inventory 工具
 */
object InventoryUtil {
    /**
     * 通过  ConfigurationSection 给设置 Inventory 物品
     *
     * @param player    玩家(用于物品Papi变量)
     * @param section   物品section
     */
    fun Inventory.setItemSection(player: Player, section: ConfigurationSection) {
        val itemStack = XItemStack.deserialize(section)
        itemStack.setLore(itemStack.getLore().replacePlaceholder(player))
        val `object` = section["index"]
        if (`object` is List<*>) {
            for (index in `object`) {
                this.setItem(itemStack, index as Int)
            }
        }
        if (`object` is Int) {
            this.setItem(itemStack, `object`)
        }
    }

    /**
     * 通过  ConfigurationSection 给设置 Inventory 物品
     *
     * @param section   物品section
     */
    fun Inventory.setItemSection(section: ConfigurationSection) {
        val itemStack = XItemStack.deserialize(section)
        val `object` = section["index"]
        if (`object` is List<*>) {
            for (index in `object`) {
                this.setItem(itemStack, index as Int)
            }
        }
        if (`object` is Int) {
            this.setItem(itemStack, `object`)
        }
    }

    /**
     * 设置 Inventory 物品
     *
     * @param itemStack 物品
     * @param index     槽位
     */
    fun Inventory.setItem(itemStack: ItemStack, index: Int) {
        if (index >= this.size) {
            return
        }
        this.setItem(index, itemStack)
    }

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
        if (itemStack.isAir) {
            return current
        }
        for (content in this.storageContents) {
            if (!itemStack.equalsItem(content)) {
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
