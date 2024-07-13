@file:Isolated

package me.yeezhi.common.util

import com.google.gson.GsonBuilder
import taboolib.common.Isolated
import taboolib.common.env.RuntimeDependency
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.InputStreamReader

@RuntimeDependency(
    value = "com.google.code.gson:gson:2.10.1",
    test = "com.google.gson_2_10_1.Gson",
    relocate = ["!com.google.gson", "!com.google.gson_2_10_1"],
    transitive = false
)
object GsonUtil {
    var gson = GsonBuilder().setPrettyPrinting().create()

    /**
     * 实体序列化写入文件
     *
     * @param any 实体
     */
    fun File.writerAny(any: Any) {
        try {
            if (!this.exists()) {
                val fileParent: File = this.getParentFile()
                if (!fileParent.exists()) {
                    fileParent.mkdirs()
                }
                this.createNewFile()
            }
            var data = gson.toJson(any)
            if (data.isEmpty()) {
                data = "{}"
            }

            FileWriter(this).use { writer -> writer.write(data) }
        } catch (e: Exception) {
            throw RuntimeException("文件 ${this.absolutePath} 写入失败", e)
        }
    }

    /**
     * 从文件读取实体
     *
     */
    fun <T> File.readAny(classOfT: Class<T>): T {
        try {
            val data = this.inputStream().use { inputStream ->
                InputStreamReader(inputStream, "UTF-8").use { reader ->
                    reader.readText()
                }
            }
            if (data.isEmpty()) {
                error("file content cannot be empty ${this.path}")
            }
            return gson.fromJson(data, classOfT)
        } catch (e: Exception) {
            throw RuntimeException("文件 ${this.absolutePath} 读取失败", e)
        }
    }

    fun Any.toJSONString(): String {
        return gson.toJson(this)
    }

    fun <T> String.toAny(classOfT: Class<T>): T {
        return gson.fromJson(this, classOfT)
    }

}
