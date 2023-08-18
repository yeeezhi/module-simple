package taboolib.module.simple.command

import net.md_5.bungee.chat.ComponentSerializer
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import taboolib.module.chat.impl.DefaultComponent

open class SubCommand {
    open lateinit var sender: CommandSender
    open lateinit var label: String
    open lateinit var args: Array<String>
    open lateinit var plugin: Plugin
    open lateinit var player: Player

    open fun showHelp(sender: CommandSender) {
        val clazz: Class<*> = this.javaClass
        val methods = clazz.getMethods()
        if (methods.isEmpty()) {
            return
        }
        sender.spigot().sendMessage(
            *ComponentSerializer.parse(
                DefaultComponent().append("§f§l " + plugin.name).hoverText(
                    """
                    §7Plugin version: §f${plugin.description.version}
                     """.trimIndent()
                ).toRawMessage()
            )
        )
        sender.sendMessage("§f ")
        sender.sendMessage("§7 命令: §f/$label§8 [...]")
        sender.sendMessage("§7 参数:")
        for (method in methods) {
            if (!method.isAnnotationPresent(CommandPart::class.java)) {
                continue
            }
            val commandPart = method.getAnnotation(CommandPart::class.java)
            if (commandPart.hide) {
                continue
            }
            // 判断是否后台
            if (!commandPart.canConsole && sender is ConsoleCommandSender) {
                continue
            }
            // 判断管理员
            if (commandPart.needAdmin && !sender.isOp) {
                continue
            }
            // 判断权限
            if (commandPart.permission.isNotEmpty() && sender.hasPermission(commandPart.permission)) {
                continue
            }
            val invokeName = if (commandPart.cmd == "") method.name else commandPart.cmd
            val msgSb = StringBuilder()
            msgSb.append("  §8- §f").append(invokeName)
            for (arg in commandPart.args) {
                msgSb.append(" §f<§7").append(arg).append("§f>")
            }
            sender.spigot().sendMessage(
                *ComponentSerializer.parse(
                    DefaultComponent().append(msgSb.toString()).hoverText("§7${commandPart.describe}")
                        .clickSuggestCommand("/${label} $invokeName").toRawMessage()
                )

            )

            sender.spigot().sendMessage(
                *ComponentSerializer.parse(
                    DefaultComponent().append("§7    " + commandPart.describe).hoverText("§7${commandPart.describe}")
                        .clickSuggestCommand("/${label} $invokeName").toRawMessage()
                )
            )
        }
    }
}
