package taboolib.module.simple.command

import org.bukkit.command.SimpleCommandMap
import org.bukkit.plugin.PluginManager
import taboolib.common.LifeCycle
import taboolib.common.inject.ClassVisitor
import taboolib.common.platform.Awake
import taboolib.platform.util.bukkitPlugin
import java.lang.reflect.Method
import java.util.function.Supplier


@Awake
object CommandLoader : ClassVisitor(0) {
    var HOOK_SUB_COMMANDS: MutableMap<String, SubCommand> = HashMap()
    var COMMAND_ARGS: MutableMap<String, Map<String, String>> = HashMap()

    override fun getLifeCycle(): LifeCycle {
        return LifeCycle.ENABLE
    }


    override fun visitEnd(clazz: Class<*>, instance: Supplier<*>?) {
        if (!clazz.isAnnotationPresent(CommandHeader::class.java)) {
            return
        }

        val commandHeader = clazz.getAnnotation(CommandHeader::class.java)
        val subCommand = clazz.newInstance() as SubCommand

        val commandMap: SimpleCommandMap
        val pm: PluginManager
        try {
            pm = bukkitPlugin.server.pluginManager
            val cmdObj = pm.javaClass.getDeclaredField("commandMap")
            cmdObj.setAccessible(true)
            commandMap = cmdObj[pm] as SimpleCommandMap
        } catch (exception: Exception) {
            throw RuntimeException("出现意外错误！${commandHeader.label}", exception)
        }
        val commandMethod: MutableMap<String, String> = HashMap()
        val methods = clazz.getMethods()

        // 用来存放所有的属性域
        val methodList: MutableList<Method> = mutableListOf()
        // 过滤带有注解的Field
        methods.forEach { method ->
            if (method.getAnnotation(CommandBody::class.java) == null) {
                return@forEach
            }
            methodList.add(method)
        }
        // 排序指令
        methodList.sortBy { it.getAnnotation(CommandBody::class.java).order }

        for (method in methodList) {
            var invokeMethodName = method.name
            val cmdAnn = method.getAnnotation(CommandBody::class.java)
            if (cmdAnn.cmd.isNotEmpty()) {
                invokeMethodName = cmdAnn.cmd
            }
            commandMethod[invokeMethodName] = method.name
        }
        commandHeader.label.forEach {
            COMMAND_ARGS[it] = commandMethod
            val cmdObj = CommandExecute(it)
            HOOK_SUB_COMMANDS[it] = subCommand
            commandMap.register(bukkitPlugin.description.name, cmdObj)
        }
    }

    @Awake(LifeCycle.DISABLE)
    fun disable() {
        HOOK_SUB_COMMANDS.clear()
        COMMAND_ARGS.clear()
    }
}
