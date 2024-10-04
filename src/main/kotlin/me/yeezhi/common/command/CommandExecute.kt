package me.yeezhi.common.command

import com.google.common.collect.ImmutableList
import org.apache.commons.lang.Validate
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.util.StringUtil
import taboolib.common.platform.function.submitAsync
import taboolib.platform.util.bukkitPlugin
import java.util.*

class CommandExecute(name: String) : Command(name) {
    override fun execute(sender: CommandSender, label: String, args: Array<String>): Boolean {
        if (!Bukkit.getPluginManager().isPluginEnabled(bukkitPlugin.name)) {
            return true
        }
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
        try {
            val invokeMethod = clazz.getMethod(invokeMethodName)
            val commandBody = invokeMethod.getAnnotation(CommandBody::class.java)
            val invokeName = if (commandBody.cmd == "") invokeMethod.name else commandBody.cmd
            // 判断是否后台
            if (!commandBody.canConsole && sender is ConsoleCommandSender) {
                return false
            }
            // 判断管理员
            if (commandBody.needAdmin && !(sender.isOp || sender.hasPermission("${bukkitPlugin.name}.cmd.$invokeName"))) {
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

    override fun tabComplete(sender: CommandSender, label: String, args: Array<String>): List<String> {
        if (!Bukkit.getPluginManager().isPluginEnabled(bukkitPlugin.name)) {
            return tabComplete0(sender, label, args, null)
        }
        if (!CommandLoader.HOOK_SUB_COMMANDS.containsKey(label)) {
            return tabComplete0(sender, label, args, null)
        }
        val subCommand = CommandLoader.HOOK_SUB_COMMANDS[label]!!
        if (args.size <= 1) {
            val clazz: Class<*> = subCommand.javaClass
            val methods = clazz.getMethods()
            if (methods.isEmpty()) {
                return tabComplete0(sender, label, args, null)
            }
            // 排序指令
            methods.sortBy { it.getAnnotation(CommandBody::class.java)?.order }
            val list: MutableList<String> = mutableListOf()
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
                if (commandBody.needAdmin && !(sender.isOp || sender.hasPermission("${bukkitPlugin.name}.cmd.$invokeName"))) {
                    continue
                }
                // 判断权限
                if (commandBody.permission.isNotEmpty() && sender.hasPermission(commandBody.permission)) {
                    continue
                }
                list.add(invokeName)
            }
            return list
        }
        return subCommand.tabComplete(sender, args).ifEmpty { tabComplete0(sender, label, args, null) }

    }

    @Throws(IllegalArgumentException::class)
    fun tabComplete0(
        sender: CommandSender, alias: String, args: Array<String>, location: Location?
    ): List<String> {
        Validate.notNull(sender, "Sender cannot be null")
        Validate.notNull(args, "Arguments cannot be null")
        Validate.notNull(alias, "Alias cannot be null")
        if (args.isEmpty()) {
            return ImmutableList.of()
        } else {
            val lastWord = args[args.size - 1]
            val senderPlayer = if (sender is Player) sender else null
            val matchedPlayers: ArrayList<String> = ArrayList<String>()
            val var9: Iterator<*> = sender.server.onlinePlayers.iterator()

            while (true) {
                var player: Player
                var name: String
                do {
                    if (!var9.hasNext()) {
                        Collections.sort(matchedPlayers, java.lang.String.CASE_INSENSITIVE_ORDER)
                        return matchedPlayers
                    }
                    player = var9.next() as Player
                    name = player.name
                } while (senderPlayer != null && !senderPlayer.canSee(player))

                if (StringUtil.startsWithIgnoreCase(name, lastWord)) {
                    matchedPlayers.add(name)
                }
            }
        }
    }
}
