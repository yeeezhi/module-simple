package taboolib.module.simple.command

import org.bukkit.command.SimpleCommandMap
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.PluginManager

object CommandCore {
    var HOOK_SUB_COMMANDS: MutableMap<String, SubCommand> = HashMap()
    var COMMAND_ARGS: MutableMap<String, Map<String, String>> = HashMap()


    fun registerCommand(label: String, subCommand: SubCommand, plugin: Plugin) {
        val commandMap: SimpleCommandMap
        val pm: PluginManager
        try {
            pm = plugin.server.pluginManager
            val cmdObj = pm.javaClass.getDeclaredField("commandMap")
            cmdObj.setAccessible(true)
            commandMap = cmdObj[pm] as SimpleCommandMap
        } catch (var15: Exception) {
            var15.printStackTrace()
            throw RuntimeException("出现意外错误！$label")
        }
        val commandMethod: MutableMap<String, String> = HashMap()
        val clazz: Class<*> = subCommand.javaClass
        val methods = clazz.getMethods()
        for (method in methods) {
            if (method.isAnnotationPresent(CommandPart::class.java)) {
                var invokeMethodName = method.name
                val cmdAnn = method.getAnnotation(CommandPart::class.java)
                if (cmdAnn.cmd.isNotEmpty()) {
                    invokeMethodName = cmdAnn.cmd
                }
                commandMethod[invokeMethodName] = method.name
            }
        }
        subCommand.plugin = plugin
        COMMAND_ARGS[label] = commandMethod
        HOOK_SUB_COMMANDS[label] = subCommand
        val cmdObj = CommandExecute(label)
        commandMap.register(plugin.description.name, cmdObj)
    }
}
