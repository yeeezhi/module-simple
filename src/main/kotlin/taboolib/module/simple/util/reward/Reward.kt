package me.qingshou.suohalottery.entity

import org.bukkit.entity.Player
import taboolib.common.platform.function.warning
import taboolib.module.chat.colored
import taboolib.module.simple.util.CommandUtil
import taboolib.module.simple.util.LangUtil
import taboolib.module.simple.util.PlayerUtil.addItem
import taboolib.module.simple.util.hook.*
import taboolib.platform.compat.replacePlaceholder
import taboolib.platform.util.bukkitPlugin

/**
 * 奖励
 */
data class Reward(
    // 奖励类型
    val type: String = "",
    // 物品ID
    val id: String = "",
    // 物品数量
    val amount: Int = 1,
    // 指令
    val command: String = "",
    // 消息
    val message: String = "",
    // 全服提醒
    val server: Boolean = false
) {

    /**
     * 获取当前奖励类型
     */

    fun rewardType(): RewardType {
        return RewardType.valueOf(type.uppercase())
    }

    fun handle(player: Player) {
        when (rewardType()) {
            RewardType.MESSAGE -> {
                val message = (LangUtil.message.getString("prefix") + message).colored().replacePlaceholder(player)
                if (server) {
                    bukkitPlugin.server.onlinePlayers.forEach {
                        it.sendMessage(message)
                    }
                } else {
                    player.sendMessage(message)
                }
            }
            RewardType.COMMAND ->  CommandUtil.dispatchCommand(player, command)
            RewardType.MM -> player.addItem(MythicMobsUtil.getItem(id, amount))
            RewardType.SX -> player.addItem( SXAttributeUtil.getItem(player, id, amount))
            RewardType.NI -> player.addItem(NeigeItemsUtil.getItem(player, id, amount))
            RewardType.MONEY -> VaultUtil.give(player, amount.toDouble())
            RewardType.PLAYERPOINTS -> PlayerPointsUtil.give(player, amount)
            RewardType.NULL -> warning("$id reward type error")
        }
    }
}

