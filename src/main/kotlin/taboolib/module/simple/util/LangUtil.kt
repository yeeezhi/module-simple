package taboolib.module.simple.util

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import taboolib.common.util.asList
import taboolib.module.chat.colored
import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration

object LangUtil {
    @Config("config.yml")
    lateinit var config: Configuration
        private set

    /**
     * 发送消息
     *
     * @param key config
     */
    @JvmStatic
    fun Player.sendLang(key: String) {
        this.sendMessage(getLang(key))
    }

    /**
     * 发送消息
     *
     * @param key config
     * @param args    占位符替换值
     */
    @JvmStatic
    fun Player.sendLang(key: String, vararg args: String) {
        this.sendMessage(format(getLang(key), args))
    }

    /**
     * 发送消息
     *
     * @param key config
     */
    @JvmStatic
    fun CommandSender.sendLang(key: String) {
        this.sendMessage(getLang(key))
    }

    /**
     * 发送消息
     *
     * @param key config
     * @param args    占位符替换值
     */
    @JvmStatic
    fun CommandSender.sendLang(key: String, vararg args: String) {
        this.sendMessage(format(getLang(key), args))
    }

    /**
     * 获取消息
     * 未来会适配多语言, 当前版本无意义
     *
     * @param key config
     */
    @JvmStatic
    fun getLang(key: String): String {
        return (config.getString("message.prefix") + config.getString(
            "message.$key",
            "§a请按照最新配置文件确保无误"
        )).colored()
    }

    /**
     * 格式化消息
     *
     * @param message 消息
     * @param args    占位符替换值
     * @return 格式化后的消息
     */
    private fun format(message: String, args: Array<out String>): String {
        var format = message
        for ((i, arg) in args.asList().withIndex()) {
            format = format.replace("{$i}", arg)
        }
        return format
    }
}