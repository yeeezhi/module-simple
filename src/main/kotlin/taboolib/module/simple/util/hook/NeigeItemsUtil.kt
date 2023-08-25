package taboolib.module.simple.util.hook

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import pers.neige.neigeitems.manager.ItemManager

/**
 * NeigeItems物品库工具
 */
object NeigeItemsUtil {
    /**
     * 根据MM物品名获取指定数量的物品
     *
     * @param itemName 物品名
     * @return 物品
     */
    fun getItem(itemName: String): ItemStack? {
        return getItem(itemName, 1)
    }

    /**
     * 根据MM物品名获取指定数量的物品
     *
     * @param itemName 物品名
     * @param amount    物品数量
     * @return 物品
     */
    fun getItem(itemName: String, amount: Int): ItemStack? {
        return try {
            val itemStack = ItemManager.getItemStack(itemName) ?: return null
            itemStack.amount = amount
            itemStack
        } catch (exception: Exception) {
            throw RuntimeException(exception)
        }
    }

    /**
     * 根据MM物品名获取物品
     *
     * @param player    玩家
     * @param itemName 物品名
     * @return 物品
     */
    fun getItem(player: Player, itemName: String): ItemStack? {
        return getItem(player, itemName, 1)
    }

    /**
     * 根据MM物品名获取指定数量的物品
     *
     * @param player    玩家
     * @param itemName 物品名
     * @param amount    物品数量
     * @return 物品
     */
    fun getItem(player: Player, itemName: String, amount: Int): ItemStack? {
        return try {
            val itemStack = ItemManager.getItemStack(itemName, player) ?: return null
            itemStack.amount = amount
            itemStack
        } catch (exception: Exception) {
            throw RuntimeException(exception)
        }
    }
}
