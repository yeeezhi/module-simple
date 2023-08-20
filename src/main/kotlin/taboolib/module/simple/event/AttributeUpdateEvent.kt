package taboolib.module.simple.event

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import taboolib.module.simple.util.ItemUtil
import taboolib.module.simple.util.ItemUtil.getLore
import taboolib.platform.type.BukkitProxyEvent
import java.util.function.Consumer

class AttributeUpdateEvent(private val player: Player) : BukkitProxyEvent() {
    private val attributeMap: MutableMap<String, MutableList<ItemStack>> = HashMap()

    /**
     * 设置玩家属性物品
     *
     * @param pluginName 插件名
     * @param list       属性物品列表
     */
    fun setItems(pluginName: String, list: MutableList<ItemStack>?) {
        if (list == null) {
            attributeMap.remove(pluginName)
            return
        }
        attributeMap[pluginName] = list
    }

    /**
     * 设置玩家属性
     *
     * @param pluginName 插件名
     * @param lore       属性列表
     */
    fun setLore(pluginName: String, lore: List<String?>) {
        if (lore.isEmpty()) {
            attributeMap.remove(pluginName)
            return
        }
        val itemStackList: MutableList<ItemStack> = ArrayList()
        val itemStack: ItemStack = ItemUtil.create(276, 0, System.currentTimeMillis().toString(), lore)
        itemStackList.add(itemStack)
        setItems(pluginName, itemStackList)
    }

    /**
     * 添加玩家属性物品
     *
     * @param pluginName 插件名
     * @param itemStack  属性物品
     */
    fun addItem(pluginName: String, itemStack: ItemStack?) {
        if (itemStack == null || itemStack.type == Material.AIR) {
            return
        }
        val itemStackList = attributeMap.computeIfAbsent(pluginName) { _ -> ArrayList() }
        itemStackList.add(itemStack)
    }

    /**
     * 添加玩家属性物品
     *
     * @param pluginName 插件名
     * @param itemStacks 属性物品数组
     */
    fun addItems(pluginName: String, itemStacks: Array<ItemStack?>) {
        for (itemStack in itemStacks) {
            if (itemStack == null || itemStack.type == Material.AIR) {
                return
            }
            val itemStackList = attributeMap.computeIfAbsent(pluginName) { _ -> ArrayList() }
            itemStackList.add(itemStack)
        }
    }

    /**
     * 添加玩家属性物品
     *
     * @param pluginName 插件名
     * @param itemStacks 属性物品数组
     */
    fun addItems(pluginName: String, itemStacks: List<ItemStack?>) {
        for (itemStack in itemStacks) {
            if (itemStack == null || itemStack.type == Material.AIR) {
                return
            }
            val itemStackList = attributeMap.computeIfAbsent(pluginName) { _ -> ArrayList() }
            itemStackList.add(itemStack)
        }
    }

    /**
     * 添加玩家属性物品
     *
     * @param pluginName 插件名
     * @param lore       属性Lore
     */
    fun addLore(pluginName: String, lore: List<String?>?) {
        if (lore.isNullOrEmpty()) {
            return
        }
        val itemStack: ItemStack = ItemUtil.create(276, 0, System.currentTimeMillis().toString(), lore)
        addItem(pluginName, itemStack)
    }

    /**
     * 移除该插件该玩家的属性物品
     *
     * @param pluginName 插件名
     */
    fun removeItems(pluginName: String) {
        attributeMap.remove(pluginName)
    }

    private val playerItemStacks: List<ItemStack>
        /**
         * 获取玩家属性物品
         *
         * @return 属性物品列表
         */
        get() {
            val itemStackList: MutableList<ItemStack> = ArrayList()
            for (itemStacks in attributeMap.values) {
                for (itemStack in itemStacks) {
                    if (itemStack.type == Material.AIR) {
                        continue
                    }
                    if (itemStack.itemMeta == null) {
                        continue
                    }
                    if (itemStack.itemMeta!!.lore == null) {
                        continue
                    }
                    if (ItemUtil.getItemLevel(itemStack) > player.level) {
                        continue
                    }
                    itemStackList.add(itemStack)
                }
            }
            return itemStackList
        }
    val playerLores: List<String>
        /**
         * 获取玩家属性Lore列表
         *
         * @return 属性物品列表
         */
        get() {
            val lore_list: MutableList<String> = ArrayList()
            playerItemStacks.forEach(Consumer { itemStack: ItemStack -> lore_list.addAll(itemStack.clone().getLore()) })
            return lore_list
        }

}
