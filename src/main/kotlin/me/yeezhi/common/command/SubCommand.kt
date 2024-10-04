package me.yeezhi.common.command

import net.md_5.bungee.chat.ComponentSerializer
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import taboolib.module.chat.impl.DefaultComponent
import taboolib.platform.util.bukkitPlugin

open class SubCommand {
    open lateinit var sender: CommandSender
    open lateinit var label: String
    open lateinit var args: Array<String>
    open lateinit var player: Player

    open fun showHelp(sender: CommandSender) {
        val clazz: Class<*> = this.javaClass
        val methods = clazz.getMethods()
        if (methods.isEmpty()) {
            return
        }

        // 排序指令
        methods.sortBy { it.getAnnotation(CommandBody::class.java)?.order }

        sender.spigot().sendMessage(
            *ComponentSerializer.parse(
                DefaultComponent().append("§f§l " + bukkitPlugin.name).hoverText(
                    """
                    §7Plugin version: §f${bukkitPlugin.description.version}
                     """.trimIndent()
                ).toRawMessage()
            )
        )
        sender.sendMessage("§f ")
        sender.sendMessage("§7 命令: §f/$label§8 [...]")
        sender.sendMessage("§7 参数:")
        for (method in methods) {
            if (!method.isAnnotationPresent(CommandBody::class.java)) {
                continue
            }
            val commandBody = method.getAnnotation(CommandBody::class.java)
            if (commandBody.hide) {
                continue
            }
            val invokeName = if (commandBody.cmd == "") method.name else commandBody.cmd
            // 判断是否后台
            if (!commandBody.canConsole && sender is ConsoleCommandSender) {
                continue
            }
            // 判断管理员
            if (commandBody.needAdmin && !(sender.isOp || sender.hasPermission("${bukkitPlugin.name.lowercase()}.cmd.$invokeName"))) {
                continue
            }
            // 判断权限
            if (commandBody.permission.isNotEmpty() && sender.hasPermission(commandBody.permission)) {
                continue
            }
            val msgSb = StringBuilder()
            msgSb.append("  §8- §f").append(invokeName)
            for (arg in commandBody.args) {
                msgSb.append(" §f<§7").append(arg).append("§f>")
            }
            sender.spigot().sendMessage(
                *ComponentSerializer.parse(
                    DefaultComponent().append(msgSb.toString()).hoverText("§7${commandBody.describe}")
                        .clickSuggestCommand("/${label} $invokeName").toRawMessage()
                )

            )

            sender.spigot().sendMessage(
                *ComponentSerializer.parse(
                    DefaultComponent().append("§7    " + commandBody.describe).hoverText("§7${commandBody.describe}")
                        .clickSuggestCommand("/${label} $invokeName").toRawMessage()
                )
            )
        }
    }


    open fun tabComplete(sender: CommandSender, args: Array<String>): List<String> {
        return listOf()
    }
}
