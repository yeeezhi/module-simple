package taboolib.module.simple.util.hook

import github.saukiya.sxattribute.SXAttribute
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

/**
 * SX物品库工具
 */
object SXAttributeUtil {
    /**
     * 根据MM物品名获取物品
     *
     * @param player    玩家
     * @param itemName 物品名
     * @return 物品
     */
    fun getItem(player: Player, itemName: String): ItemStack {
        return try {
            val itemStack = SXAttribute.getApi().getItem(itemName, player)
            itemStack.amount = 1
            itemStack
        } catch (exception: Exception) {
            throw RuntimeException(exception)
        }
    }

    /**
     * 根据MM物品名获取指定数量的物品
     *
     * @param player    玩家
     * @param itemName 物品名
     * @param amount    物品数量
     * @return 物品
     */
    fun getItem(player: Player, itemName: String, amount: Int): ItemStack {
        return try {
            val itemStack = SXAttribute.getApi().getItem(itemName, player)
            itemStack.amount = amount
            itemStack
        } catch (exception: Exception) {
            throw RuntimeException(exception)
        }
    }
}
