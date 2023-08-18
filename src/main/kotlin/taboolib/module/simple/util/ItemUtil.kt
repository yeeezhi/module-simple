package taboolib.module.simple.util

import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import taboolib.module.chat.colored
import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration
import taboolib.platform.compat.replacePlaceholder
import java.util.*
import kotlin.math.min

/**
 * 物品工具
 */
object ItemUtil {

    @Config("config.yml")
    lateinit var config: Configuration
        private set


    fun isItem(itemStack: ItemStack?): Boolean {
        return isItemStack(itemStack)
    }

    /**
     * 判断ItemStack是否是物品
     *
     * @param itemStack 物品
     * @return true: 是物品,false: 物品为Null或者类型为AIR
     */

    fun isItemStack(itemStack: ItemStack?): Boolean {
        val version = Bukkit.getServer().javaClass.getPackage().name.replace(".", ",").split(",".toRegex())
            .dropLastWhile { it.isEmpty() }.toTypedArray()[3]
        if (itemStack == null) {
            return false
        }
        // 高版本
        return if (version.contains("v1_13") || version.contains("v1_14") || version.contains("v1_15") || version.contains(
                "v1_16"
            ) || version.contains(
                "v1_17"
            )
        ) {
            itemStack.type.isItem
        } else itemStack.type != Material.AIR
    }

    /**
     * 获取物品名
     *
     * @param itemStack 物品
     * @return 物品名
     */

    fun getDisplayName(itemStack: ItemStack): String {
        if (!isItemStack(itemStack)) {
            return "无"
        }
        return if (itemStack.itemMeta.displayName == null) {
            cnName(itemStack.type)
        } else itemStack.itemMeta.displayName
    }

    /**
     * 获取物品Lore列表
     *
     * @param itemStack 物品
     * @return 物品Lore列表
     */

    fun getLore(itemStack: ItemStack): List<String> {
        val list: List<String> = ArrayList()
        if (!isItemStack(itemStack)) {
            return list
        }
        return if (itemStack.itemMeta.lore == null) {
            list
        } else itemStack.itemMeta.lore
    }

    /**
     * 获取物品Lore列表
     *
     * @param itemStack 物品
     * @return 物品Lore列表
     */

    fun setLore(itemStack: ItemStack, list: List<String>): ItemStack {
        if (!isItemStack(itemStack)) {
            return itemStack
        }
        if (itemStack.itemMeta == null) {
            return itemStack
        }
        val itemMeta = itemStack.itemMeta
        itemMeta.lore = list
        itemStack.setItemMeta(itemMeta)
        return itemStack
    }

    /**
     * 替换物品Lore
     *
     * @param itemStack   物品
     * @param target      原字符串
     * @param replacement 替换后字符串
     */

    fun replaceLore(itemStack: ItemStack, target: String, replacement: String): ItemStack {
        val loreList: MutableList<String> = ArrayList()
        for (str in getLore(itemStack)) {
            val lore = str.replace(target, replacement)
            loreList.add(lore)
        }
        return setLore(itemStack, loreList)
    }

    /**
     * 替换物品Lore
     *
     * @param itemStack   物品
     * @param target      原字符串
     * @param replacement 替换后字符串列表
     */

    fun replaceLore(itemStack: ItemStack, target: String, replacement: List<String>): ItemStack {
        val loreList: MutableList<String> = ArrayList()
        for (lore in getLore(itemStack)) {
            if (lore.contains(target)) {
                loreList.add(lore.replace(target, ""))
                loreList.addAll(replacement)
                continue
            }
            loreList.add(lore)
        }
        return setLore(itemStack, loreList)
    }

    /**
     * 替换物品Name
     *
     * @param itemStack   物品
     * @param target      原字符串
     * @param replacement 替换后字符串
     */

    fun replaceName(itemStack: ItemStack, target: String?, replacement: String?): ItemStack {
        if (!isItemStack(itemStack)) {
            return itemStack
        }
        if (itemStack.itemMeta == null) {
            return itemStack
        }
        val itemMeta = itemStack.itemMeta
        if (itemMeta.displayName == null) {
            return itemStack
        }
        val name = itemMeta.displayName
        itemMeta.displayName = name.replace(target!!, replacement!!)
        itemStack.setItemMeta(itemMeta)
        return itemStack
    }

    /**
     * 物品添加附魔
     *
     * @param itemStack              物品
     * @param enchantment            附魔
     * @param level                  附魔等级
     * @param ignoreLevelRestriction 忽略等级限制
     * @return 物品
     */

    fun addEnchant(
        itemStack: ItemStack, enchantment: Enchantment?, level: Int, ignoreLevelRestriction: Boolean
    ): ItemStack {
        if (!isItemStack(itemStack)) {
            return itemStack
        }
        if (itemStack.itemMeta == null) {
            return itemStack
        }
        val itemMeta = itemStack.itemMeta
        itemMeta.addEnchant(enchantment, level, ignoreLevelRestriction)
        itemStack.setItemMeta(itemMeta)
        return itemStack
    }

    /**
     * 判断ItemStack是否有Lore
     *
     * @param itemStack 物品
     * @return true: 物品有Lore,false: 物品为null或者无Lore
     */

    fun isLore(itemStack: ItemStack): Boolean {
        return if (!isItemStack(itemStack)) {
            false
        } else itemStack.itemMeta != null && itemStack.itemMeta.lore != null
    }


    fun getItemLevel(item: ItemStack): Int {
        return if (item.hasItemMeta() && item.itemMeta.hasLore()) item.itemMeta.lore.stream()
            .filter { lore: String ->
                lore.contains(
                    config.getString("Config.LevelLimit", "等级限制")!!
                )
            }.findFirst().map { lore: String -> StringUtil.getNumber(lore).replace(".", "").toInt() }
            .orElse(-1) else -1
    }


    fun equalsItem(item1: ItemStack?, item2: ItemStack?): Boolean {
        // 判断两物品是否都为null
        if (item1 == null || item2 == null) {
            return false
        }
        // 判断两物品是否相等
        if (item1 === item2) {
            return true
        }
        // 判断两物品类型是否相等
        if (item1.type != item2.type) {
            return false
        }
        // 判断两物品耐久是否相等
        if (item1.durability != item2.durability) {
            return false
        }
        // 判断两物品ItemMeta是否相等
        if (item1.hasItemMeta() != item2.hasItemMeta()) {
            return false
        }
        // 判断两物品ItemMeta是否都为null
        return if (item1.itemMeta == null && item2.itemMeta == null) {
            true
        } else Bukkit.getItemFactory().equals(item1.itemMeta, item2.itemMeta)
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

    fun create(id: Int, data: Int, name: String?, lore: List<String?>?): ItemStack {
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
     * 获取物品中文名
     *
     * @param material Material
     * @return 物品中文名
     */

    fun cnName(material: Material?): String {
        return NameUtil.toChinese(material)
    }

    /**
     * 获取客户端物品名
     *
     * @param material Material
     * @return 客户端物品名
     */

    fun clientName(material: Material?): String {
        return NameUtil.clientName(material)
    }


    fun getItemNBT(item: ItemStack?): String {
        val version = Bukkit.getServer().javaClass.getPackage().name.replace(".", ",").split(",".toRegex())
            .dropLastWhile { it.isEmpty() }.toTypedArray()[3]
        return try {
            val saveItem = Class.forName("net.minecraft.server.$version.ItemStack")
            val CraftItemStack = Class.forName("org.bukkit.craftbukkit.$version.inventory.CraftItemStack")
            val NBTTagCompound = Class.forName("net.minecraft.server.$version.NBTTagCompound")
            val asNMSCopy = CraftItemStack.getMethod("asNMSCopy", ItemStack::class.java)
            val save = saveItem.getMethod("save", NBTTagCompound)
            val tag = NBTTagCompound.newInstance()
            val NMSItem = asNMSCopy.invoke(null, item)
            val saves = save.invoke(NMSItem, tag)
            saves.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            "null"
        }
    }

    /**
     * 通过section获取ItemStack
     * section格式:
     * Id: 276
     * Data: 0
     * Name: "测试物品"
     * Lore:
     * - "测试Lore"
     * - "测试Lore2"
     *
     * @param section 物品section
     * @return 获取的物品
     */

    fun getItemStack(section: ConfigurationSection): ItemStack {
        val id = section.getInt("Id")
        val data = section.getInt("Data")
        val name = section.getString("Name")
        val loreList = section.getStringList("Lore").colored()
        val itemStack = create(id, data, name, loreList)
        if (section.getKeys(false).contains("Amount")) {
            itemStack.amount = min(section.getInt("Amount").toDouble(), itemStack.maxStackSize.toDouble()).toInt()
        }
        // 物品附魔
        if (section.getKeys(false).contains("Enchantment")) {
            val enchantmentSection = section.getConfigurationSection("Enchantment")
            for (enchantment in enchantmentSection.getKeys(false)) {
                val level = enchantmentSection.getInt(enchantment)
                addEnchant(itemStack, Enchantment.getByName(enchantment), level, true)
            }
        }
        return itemStack
    }

    /**
     * 通过section获取ItemStack(支持PAPI)
     * section格式:
     * Id: 276
     * Data: 0
     * Name: "测试物品"
     * Lore:
     * - "测试Lore"
     * - "测试Lore2"
     *
     * @param player  玩家
     * @param section 物品section
     * @return 获取的物品
     */

    fun getItemStack(player: Player, section: ConfigurationSection): ItemStack {
        val itemStack = getItemStack(section)
        val lore_list = getLore(itemStack)
        return if (lore_list.size == 0) {
            itemStack
        } else setLore(
            itemStack, lore_list.replacePlaceholder(player)
        )
    }

    /**
     * 合并物品数量
     * 将不同堆里面的物品合并数量
     *
     * @param itemStacks 物品列表
     * @return 合并后的物品列表
     */

    fun arrangeItemStacks(itemStacks: List<ItemStack?>): List<ItemStack> {
        val list: MutableList<ItemStack> = ArrayList()
        for (item in itemStacks) {
            if (item == null || item.type == Material.AIR) {
                continue
            }
            val itemStack = item.clone()
            var add = true
            for (itemStack1 in list) {
                if (itemStack.itemMeta == itemStack1.itemMeta) {
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