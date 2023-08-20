package taboolib.module.simple.util

import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import taboolib.library.configuration.ConfigurationSection
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

    /**
     * 判断ItemStack是否是物品
     *
     * @return true: 是物品,false: 物品为Null或者类型为AIR
     */

    fun ItemStack?.isItemStack(): Boolean {
        val version = Bukkit.getServer().javaClass.getPackage().name.replace(".", ",").split(",".toRegex())
            .dropLastWhile { it.isEmpty() }.toTypedArray()[3]
        if (this == null) {
            return false
        }
        // 低版本
        return if (version.contains("v1_12") || version.contains("v1_11") || version.contains("v1_10") || version.contains(
                "v1_9"
            ) || version.contains("v1_8")
        ) {
            this.type != Material.AIR
        } else this.type.isItem
    }


    /**
     * 获取物品Lore列表
     *
     * @return 物品Lore列表
     */

    fun ItemStack.getLore(): MutableList<String> {
        val list: MutableList<String> = ArrayList()
        if (!this.isItemStack()) {
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
        if (!this.isItemStack()) {
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
        if (!this.isItemStack()) {
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
        return if (!this.isItemStack()) {
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
        val enchantmentSection = section.getConfigurationSection("Enchantment")
        if (enchantmentSection == null) {
            return itemStack
        }
        for (enchantment in enchantmentSection.getKeys(false)) {
            val level = enchantmentSection.getInt(enchantment)
            itemStack.addEnchant(Enchantment.getByName(enchantment), level, true)

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
        val loreList = itemStack.getLore()
        return if (loreList.isEmpty()) {
            itemStack
        } else itemStack.setLore(
            loreList.replacePlaceholder(player)
        )
    }

    /**
     * 合并物品数量
     * 将不同堆里面的物品合并数量
     *
     * @param itemStacks 物品列表
     * @return 合并后的物品列表
     */

    fun arrangeItemStacks(itemStacks: List<ItemStack>): List<ItemStack> {
        val list: MutableList<ItemStack> = ArrayList()
        for (item in itemStacks) {
            if (item.type == Material.AIR) {
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