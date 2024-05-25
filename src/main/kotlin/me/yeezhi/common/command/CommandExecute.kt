package me.yeezhi.common.command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import taboolib.common.platform.function.submitAsync
import taboolib.platform.util.bukkitPlugin

class CommandExecute(name: String) : Command(name) {
    override fun execute(sender: CommandSender, label: String, args: Array<String>): Boolean {
        if (!CommandLoader.HOOK_SUB_COMMANDS.containsKey(label)) {
            return false
        }
        val subCommand = CommandLoader.HOOK_SUB_COMMANDS[label]!!
        subCommand.sender = sender
        subCommand.label = label
        subCommand.args = args
        if (sender is Player) {
            subCommand.player = sender
        }
        val clazz: Class<*> = subCommand.javaClass
        if (args.isEmpty()) {
            subCommand.showHelp(sender)
            return true
        }
        val labelMap = CommandLoader.COMMAND_ARGS[label]
        if (labelMap.isNullOrEmpty()) {
            return true
        }
        val invokeMethodName = labelMap[args[0]]
        if (invokeMethodName == null) {
            subCommand.showHelp(sender)
            return true
        }
        if (!bukkitPlugin.isEnabled) {
            return true
        }
        try {
            val invokeMethod = clazz.getMethod(invokeMethodName)
            val commandBody = invokeMethod.getAnnotation(CommandBody::class.java)
            // 判断是否后台
            if (!commandBody.canConsole && sender is ConsoleCommandSender) {
                return false
            }
            // 判断管理员
            if (commandBody.needAdmin && !sender.isOp) {
                return false
            }
            // 判断权限
            if (commandBody.permission.isNotEmpty() && sender.hasPermission(commandBody.permission)) {
                return false
            }
            invokeMethod.setAccessible(true)
            if (commandBody.async) {
                submitAsync { invokeMethod.invoke(subCommand) }
            } else {
                invokeMethod.invoke(subCommand)
            }
        } catch (exception: Exception) {
            throw RuntimeException(exception)
        }
        return true
    }
}
