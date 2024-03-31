package me.yeezhi.common.util

import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration
import taboolib.platform.util.isAir
import java.util.*

/**
 * 物品工具
 */
object ItemUtil {

    @Config("config.yml")
    lateinit var config: Configuration
        private set

    /**
     * 获取物品Lore列表
     *
     * @return 物品Lore列表
     */

    fun ItemStack.getLore(): MutableList<String> {
        val list: MutableList<String> = ArrayList()
        if (this.isAir) {
            return list
        }
        return if (this.itemMeta.lore == null) {
            list
        } else this.itemMeta.lore
    }

    /**
     * 获取物品Lore列表
     *
     * @return 物品Lore列表
     */

    fun ItemStack.setLore(list: List<String>): ItemStack {
        if (this.isAir) {
            return this
        }
        if (this.itemMeta == null) {
            return this
        }
        val itemMeta = this.itemMeta
        itemMeta.lore = list
        this.setItemMeta(itemMeta)
        return this
    }


    /**
     * 物品添加附魔
     *
     * @param enchantment            附魔
     * @param level                  附魔等级
     * @param ignoreLevelRestriction 忽略等级限制
     * @return 物品
     */

    fun ItemStack.addEnchant(
        enchantment: Enchantment, level: Int, ignoreLevelRestriction: Boolean
    ): ItemStack {
        if (this.isAir) {
            return this
        }
        if (this.itemMeta == null) {
            return this
        }
        val itemMeta = this.itemMeta
        itemMeta.addEnchant(enchantment, level, ignoreLevelRestriction)
        this.setItemMeta(itemMeta)
        return this
    }

    /**
     * 判断ItemStack是否有Lore
     *
     * @return true: 物品有Lore,false: 物品为null或者无Lore
     */

    fun ItemStack.isLore(): Boolean {
        return if (this.isAir) {
            false
        } else this.itemMeta != null && this.itemMeta.lore != null
    }


    fun getItemLevel(item: ItemStack): Int {
        return if (item.hasItemMeta() && item.itemMeta.hasLore()) item.itemMeta.lore.stream().filter { lore: String ->
            lore.contains(
                config.getString("config.levelLimit", "等级限制")!!
            )
        }.findFirst().map { lore: String -> StringUtil.getNumber(lore).replace(".", "").toInt() }.orElse(-1) else -1
    }


    fun ItemStack?.equalsItem(itemStack: ItemStack?): Boolean {
        // 判断两物品是否都为null
        if (this == null || itemStack == null) {
            return false
        }
        // 判断两物品是否相等
        if (this === itemStack) {
            return true
        }
        // 判断两物品类型是否相等
        if (this.type != itemStack.type) {
            return false
        }
        // 判断两物品耐久是否相等
        if (this.durability != itemStack.durability) {
            return false
        }
        // 判断两物品ItemMeta是否相等
        if (this.hasItemMeta() != itemStack.hasItemMeta()) {
            return false
        }
        // 判断两物品ItemMeta是否都为null
        return if (this.itemMeta == null && itemStack.itemMeta == null) {
            true
        } else Bukkit.getItemFactory().equals(this.itemMeta, itemStack.itemMeta)
        // 判断两物品ItemMeta是否相等
    }

    /**
     * 修改物品Name和Lore
     *
     * @param item 物品
     * @param name 物品名
     * @param lore 物品Lore
     * @return 修改后的物品
     */

    fun create(item: ItemStack, name: String, vararg lore: String): ItemStack {
        val loreList: MutableList<String>
        val meta = item.itemMeta
        meta.displayName = name
        if (meta.hasLore()) {
            loreList = meta.lore
            loreList[0] = "§a" + ChatColor.stripColor(meta.lore[0])
        } else {
            loreList = ArrayList()
        }
        Collections.addAll(loreList, *lore)
        meta.lore = loreList
        item.setItemMeta(meta)
        return item
    }

    /**
     * 创建物品
     *
     * @param id   物品ID
     * @param data 物品Data
     * @param name 物品名
     * @param lore 物品Lore
     * @return 创建的物品
     */

    fun create(id: Int, data: Int, name: String, vararg lore: String): ItemStack {
        val loreList: MutableList<String>
        val item = ItemStack(Material.getMaterial(id))
        val meta = item.itemMeta
        meta.displayName = name
        item.durability = data.toShort()
        loreList = if (meta.hasLore()) {
            meta.lore
        } else {
            ArrayList()
        }
        loreList.addAll(lore.toList())
        meta.lore = loreList
        item.setItemMeta(meta)
        return item
    }

    /**
     * 创建物品
     *
     * @param id   物品ID
     * @param data 物品Data
     * @param name 物品名
     * @param lore 物品Lore
     * @return 创建的物品
     */

    fun create(id: Int, data: Int, name: String?, lore: List<String?>): ItemStack {
        val item = ItemStack(Material.getMaterial(id))
        item.durability = data.toShort()
        val meta = item.itemMeta
        if (name != null) {
            meta.displayName = name
        }
        meta.lore = lore
        item.setItemMeta(meta)
        return item
    }


    /**
     * 合并物品数量
     * 将不同堆里面的物品合并数量
     *
     * @param itemStacks 物品列表
     * @return 合并后的物品列表
     */

    fun arrangeItemStacks(itemStacks: List<ItemStack>): MutableList<ItemStack> {
        val list: MutableList<ItemStack> = ArrayList()
        for (item in itemStacks) {
            if (item.type == Material.AIR) {
                continue
            }
            val itemStack = item.clone()
            var add = true
            for (itemStack1 in list) {
                if (itemStack.equalsItem(itemStack1)) {
                    itemStack1.amount += itemStack.amount
                    add = false
                }
            }
            if (add) {
                list.add(itemStack)
            }
        }
        return list
    }

}