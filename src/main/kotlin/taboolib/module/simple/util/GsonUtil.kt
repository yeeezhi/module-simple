@file:Isolated

package taboolib.module.simple.util

import cn.hutool.core.io.file.FileReader
import cn.hutool.core.io.file.FileWriter
import com.google.gson.Gson
import org.serverct.ersha.jd.T
import taboolib.common.Isolated
import java.io.File

object GsonUtil {
    val gson = Gson()

    /**
     * 实体序列化写入文件
     *
     * @param any 实体
     */
    fun File.writerAny(any: Any) {
        val writer = FileWriter(this)
        writer.write(gson.toJson(any))
    }

    /**
     * 从文件读取实体
     *
     */
    fun <T> File.readAny(classOfT: Class<T>): T {
        val fileReader = FileReader(this)
        return gson.fromJson(fileReader.readString(), classOfT)
    }

    fun Any.toJSONString(): String {
        return gson.toJson(this)
    }

    fun <T> String.toAny(classOfT: Class<T>): T {
        return gson.fromJson(this, classOfT)
    }
}
