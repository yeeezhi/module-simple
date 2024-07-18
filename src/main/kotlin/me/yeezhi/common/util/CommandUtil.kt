package me.yeezhi.common.util

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import taboolib.common.platform.function.submit
import taboolib.platform.compat.replacePlaceholder
import java.util.function.Consumer

/**
 * 指令执行工具
 */
object CommandUtil {
    /**
     * 执行指令
     *
     * @param player   玩家
     * @param commands 指令列表
     */
    fun Player.dispatchCommand(commands: List<String>) {
        val player = this
        submit {
            commands.forEach(Consumer { command: String -> player.dispatchCommand(command) })
        }
    }

    /**
     * 执行指令,支持颜色代码,支持PAPI变量
     * 前缀 默认后台执行, player: 玩家执行,op: 玩家以OP权限执行
     *
     * @param command 指令
     */
    fun Player.dispatchCommand(command: String) {
        val player = this
        var command = command
        command = command.replacePlaceholder(player)
        if (command.startsWith("player:")) {
            command = command.split("player:".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
            Bukkit.dispatchCommand(player, command)
            return
        }
        if (command.startsWith("op:")) {
            command = command.split("op:".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
            if (player.isOp) {
                Bukkit.dispatchCommand(player, command)
                return
            }
            player.isOp = true
            try {
                Bukkit.dispatchCommand(player, command)
            } catch (ignored: Exception) {
            }
            player.isOp = false
            return
        }
        submit {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command)
        }
    }
}
