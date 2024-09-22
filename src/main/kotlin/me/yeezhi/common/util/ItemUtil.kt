package me.yeezhi.common.util

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import taboolib.platform.util.*
import java.nio.charset.StandardCharsets
import java.util.*

/**
 * 物品工具
 */
object ItemUtil {
    fun String.deserializeToItemStack(): ItemStack {
        return Base64.getDecoder().decode(this).deserializeToItemStack()
    }

    fun ItemStack.serializeToBase64(): String {
        return Base64.getEncoder().encode(this.serializeToByteArray()).toString(StandardCharsets.UTF_8)
    }


    /**
     * 获取物品Lore列表
     *
     * @return 物品Lore列表
     */

    fun ItemStack.getLore(): MutableList<String> {
        if (this.isAir) {
            return mutableListOf()
        }
        return if (this.itemMeta.lore == null) {
            mutableListOf()
        } else this.itemMeta.lore
    }

    /**
     * 设置物品Lore列表
     *
     * @return 物品
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
     * 设置物品Name
     *
     * @return 物品
     */

    fun ItemStack.setName(name: String): ItemStack {
        if (this.isAir) {
            return this
        }
        if (this.itemMeta == null) {
            return this
        }
        val itemMeta = this.itemMeta
        itemMeta.displayName = name
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
     * 合并物品数量
     * 将不同堆里面的物品合并数量
     *
     * @param itemStacks 物品列表
     * @return 合并后的物品列表
     */

    fun List<ItemStack>.arrange(): MutableList<ItemStack> {
        val list: MutableList<ItemStack> = ArrayList()
        for (item in this) {
            if (item.type == Material.AIR) {
                continue
            }
            val itemStack = item.clone()
            var add = true
            for (itemStack1 in list) {
                if (itemStack.isSimilar(itemStack1)) {
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