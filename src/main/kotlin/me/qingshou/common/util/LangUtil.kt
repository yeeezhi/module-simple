package me.qingshou.common.util

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import taboolib.common.platform.ProxyPlayer
import taboolib.common.util.asList
import taboolib.module.chat.colored
import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration

object LangUtil {
    @Config("message.yml", autoReload = true)
    lateinit var message: Configuration
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
    fun Player.sendLang(key: String, vararg args: Any) {
        this.sendMessage(getLang(key, * args))
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
    fun CommandSender.sendLang(key: String, vararg args: Any) {
        this.sendMessage(getLang(key, *args))
    }

    /**
     * 发送消息
     *
     * @param key config
     */
    @JvmStatic
    fun ProxyPlayer.sendLang(key: String) {
        this.sendMessage(getLang(key))
    }

    /**
     * 发送消息
     *
     * @param key config
     * @param args    占位符替换值
     */
    @JvmStatic
    fun ProxyPlayer.sendLang(key: String, vararg args: Any) {
        this.sendMessage(getLang(key, *args))
    }

    /**
     * 获取消息
     * 未来会适配多语言, 当前版本无意义
     *
     * @param key config
     */
    @JvmStatic
    fun getLang(key: String, prefix: Boolean = true): String {
        return if (prefix) {
            (message.getString("prefix") + message.getString(key, key)).colored()
        } else {
            message.getString(key, key)!!.colored()
        }
    }

    /**
     * 获取消息
     *
     * @param key config
     * @param args    占位符替换值
     */
    @JvmStatic
    fun getLang(key: String, vararg args: Any, prefix: Boolean = true): String {
        return if (prefix) {
            format((message.getString("prefix") + message.getString(key, key)).colored(), *args)
        } else {
            format(message.getString(key, key)!!.colored(), *args)
        }
    }

    /**
     * 格式化消息
     *
     * @param message 消息
     * @param args    占位符替换值
     * @return 格式化后的消息
     */
    fun format(message: String, vararg args: Any): String {
        var format = message
        for ((i, arg) in args.asList().withIndex()) {
            format = format.replace("{$i}", arg)
        }
        return format
    }
}