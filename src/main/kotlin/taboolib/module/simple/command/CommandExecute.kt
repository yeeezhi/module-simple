package taboolib.module.simple.command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player

class CommandExecute(name: String) : Command(name) {
    override fun execute(sender: CommandSender, label: String, args: Array<String>): Boolean {
        if (!CommandCore.HOOK_SUB_COMMANDS.containsKey(label)) {
            return false
        }
        val subCommand = CommandCore.HOOK_SUB_COMMANDS[label]!!
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
        val labelMap = CommandCore.COMMAND_ARGS[label]
        if (labelMap.isNullOrEmpty()) {
            return true
        }
        val invokeMethodName = labelMap[args[0]]
        if (invokeMethodName == null) {
            subCommand.showHelp(sender)
            return true
        }
        val plugin = subCommand.plugin
        if (!plugin.isEnabled) {
            return true
        }
        try {
            val invokeMethod = clazz.getMethod(invokeMethodName)
            val commandPart = invokeMethod.getAnnotation(CommandPart::class.java)
            // 判断是否后台
            if (!commandPart.canConsole && sender is ConsoleCommandSender) {
                return false
            }
            // 判断管理员
            if (commandPart.needAdmin && !sender.isOp) {
                return false
            }
            // 判断权限
            if (commandPart.permission.isNotEmpty() && sender.hasPermission(commandPart.permission)) {
                return false
            }
            invokeMethod.setAccessible(true)
            invokeMethod.invoke(subCommand)
            println(invokeMethod.typeParameters.size)
        } catch (var11: Exception) {
            throw RuntimeException(var11)
        }
        return true
    }
}
