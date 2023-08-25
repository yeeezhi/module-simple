package taboolib.module.simple.util

import taboolib.module.configuration.ConfigSection
import taboolib.module.configuration.Configuration
import taboolib.platform.util.bukkitPlugin
import java.io.InputStreamReader

object ConfigUtil {
    /**
     * 配置文件补全,移除多余参数
     */
    fun Configuration.restock(path: String): Configuration {
        val origin = bukkitPlugin.getResource(path)?.let {
            val reader = InputStreamReader(it, "UTF-8")
            val config = Configuration.loadFromReader(reader)
            reader.close()
            config
        } ?: return this
        origin.getKeys(true).forEach { key ->
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
            if (!origin.contains(key)) {
                this[key] = null
            }
        }
        this.saveToFile(this.file)
        return this
    }
}
