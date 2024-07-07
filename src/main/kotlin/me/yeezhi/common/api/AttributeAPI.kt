package me.yeezhi.common.api

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import taboolib.platform.util.ItemBuilder
import taboolib.platform.util.buildItem
import java.util.*


object AttributeAPI {
    private val attributeMap: MutableMap<UUID, MutableList<ItemStack>> = mutableMapOf()

    /**
     * 设置玩家属性物品
     * @param list 物品列表
     */
    fun Player.setAttributeItems(list: MutableList<ItemStack>) {
        attributeMap[this.uniqueId] = list
    }

    /**
     * 设置玩家属性
     * @param list 属性词条
     */
    fun Player.setAttributeLores(list: MutableList<String>) {
        attributeMap[this.uniqueId] = mutableListOf(buildItem(Material.NETHER_STAR) { lore.addAll(list) })
    }

    /**
     * 添加玩家属性物品
     * @param itemStack 物品
     */
    fun Player.addAttributeItem(itemStack: ItemStack) {
        val list = attributeMap[this.uniqueId] ?: mutableListOf()
        list.add(itemStack)
        attributeMap[this.uniqueId] = list
    }

    /**
     * 清空玩家属性物品
     */
    fun Player.clearAttributeItems() {
        attributeMap.remove(this.uniqueId)
    }

    /**
     * 获取玩家属性物品列表
     */
    fun Player.getAttributeItems(): MutableList<ItemStack> {
        return attributeMap[this.uniqueId] ?: mutableListOf()
    }

    /**
     * 获取玩家属性列表
     */
    fun Player.getAttributeLores(): MutableList<String> {
        val map = attributeMap[this.uniqueId] ?: return mutableListOf()
        return map.flatMap { ItemBuilder(it).lore }.toMutableList()
    }
}

