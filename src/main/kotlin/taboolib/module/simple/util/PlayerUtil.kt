package taboolib.module.simple.util

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import taboolib.platform.util.giveItem
import taboolib.platform.util.isAir
import kotlin.math.min

/**
 * Player工具
 */
object PlayerUtil {
    /**
     * 给予玩家物品
     *
     * @param itemStack 物品
     */
    fun Player.addItem(itemStack: ItemStack) {
        val list: MutableList<ItemStack> = ArrayList()
        list.add(itemStack)
        player.addItem(list)
    }

    /**
     * 给予玩家物品
     *
     * @param list   物品列表
     */
    fun Player.addItem(list: MutableList<ItemStack>) {
        if (!player.isOnline || list.isEmpty()) {
            return
        }
        // 解决堆叠超过上限的问题
        for (itemStack in list) {
            if (itemStack.isAir) {
                continue
            }
            var amount = itemStack.amount
            while (amount > 0) {
                val itemClone = itemStack.clone()
                itemClone.amount = min(amount, itemClone.maxStackSize)
                amount -= itemClone.amount
                player.giveItem(itemClone)
            }
        }
    }
}
