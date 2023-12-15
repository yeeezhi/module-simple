package taboolib.module.simple.util

import org.bukkit.configuration.file.YamlConfiguration
import taboolib.module.configuration.ConfigSection
import taboolib.module.configuration.Configuration
import taboolib.platform.util.bukkitPlugin
import java.io.InputStreamReader

object ConfigUtil {
    /**
     * 获取路径下Section的keys
     * @param path 路径
     */
    fun Configuration.keys(path: String): Set<String> {
        val yaml = YamlConfiguration.loadConfiguration(this.file!!)
        return yaml.getConfigurationSection(path)?.getKeys(false) ?: setOf()
    }
    /**
     * 配置文件补全,移除多余参数
     */
    fun Configuration.restock(path: String, excludes: List<String> = emptyList()): Configuration {
        val origin = bukkitPlugin.getResource(path)?.let {
            val reader = InputStreamReader(it, "UTF-8")
            val config = Configuration.loadFromReader(reader)
            reader.close()
            config
        } ?: return this
        origin.getKeys(true).forEach { key ->
            excludes.forEach exclude@ {exclude ->
                if (key.contains(exclude)){
                    return@forEach
                }
            }
            if (!this.contains(key)) {
                this[key] = origin[key]
            } else {
                val completeValue = origin[key]
                val value = this[key]
                if (completeValue is ConfigSection && value !is ConfigSection) {
                    this[key] = completeValue
                }
            }
        }

        this.getKeys(true).forEach { key ->
            excludes.forEach exclude@ {exclude ->
                if (key.contains(exclude)){
                    return@forEach
                }
            }
            if (excludes.contains(key)) {
                return@forEach
            }
            if (!origin.contains(key)) {
                this[key] = null
            }
        }
        this.saveToFile(this.file)
        return this
    }
}
