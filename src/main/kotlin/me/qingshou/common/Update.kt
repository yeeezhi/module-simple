package me.qingshou.common

import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.console
import taboolib.common.util.replaceWithOrder
import taboolib.module.configuration.Configuration
import me.qingshou.common.util.HttpUtil
import me.qingshou.common.util.StringUtil
import taboolib.platform.util.bukkitPlugin
import java.net.URL

object Update {
    @Awake(LifeCycle.ACTIVE)
    fun task() {
        val content = HttpUtil.downloadContent(URL("https://www.goodmc.cn/plugin/version.yml"))
        val config = Configuration.loadFromString(content)
        val pluginSection = config.getConfigurationSection("plugins") ?: return
        if (!pluginSection.contains(bukkitPlugin.name)) {
            return
        }
        val pluginInfo = pluginSection.getConfigurationSection(bukkitPlugin.name) ?: return
        val version = pluginInfo.getString("version")!!
        val url = pluginInfo.getString("url")!!
        val update = pluginInfo.getStringList("update")
        if (StringUtil.compareVersion(bukkitPlugin.description.version, version) >= 0) {
            return
        }
        val prefix = config.getString("message.prefix")!!.replaceWithOrder(bukkitPlugin.name)
        val versionMsg = config.getString("message.version")!!.replaceWithOrder(version)
        val downloadMsg = config.getString("message.download")!!.replaceWithOrder(url)
        val updateMsg = config.getString("message.update")!!
        val updateHead = config.getString("message.update_head")!!
        console().sendMessage(prefix + versionMsg)
        console().sendMessage(prefix + downloadMsg)
        console().sendMessage(prefix + updateMsg)
        update.forEach { console().sendMessage(prefix + updateHead + it) }
        console().sendMessage(updateHead)
        bukkitPlugin.file.delete()
    }

}
