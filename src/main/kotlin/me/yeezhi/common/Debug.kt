package me.yeezhi.common

import taboolib.common.platform.function.info
import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration

@Config("config.yml", autoReload = true)
lateinit var config: Configuration
    private set


/**
 * 格式化消息
 *
 * @param message 消息
 * @param args    占位符替换值
 * @return 格式化后的消息
 */
fun debug(message: String) {
    if (!config.getBoolean("debug")) {
        return
    }
    info(message)
}