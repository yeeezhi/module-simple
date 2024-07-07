package me.yeezhi.common.util

import me.yeezhi.common.util.ItemUtil.getLore
import me.yeezhi.common.util.ItemUtil.setLore
import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration
import taboolib.platform.util.ItemBuilder
import taboolib.platform.util.hasLore
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
        return ItemBuilder(this).lore
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

    fun  List<ItemStack>.arrange(): MutableList<ItemStack> {
        val list: MutableList<ItemStack> = ArrayList()
        this.forEach f1@{
            if (it.isAir){
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