package taboolib.module.simple.util

import cn.hutool.core.io.FileUtil
import cn.hutool.core.io.file.FileReader
import cn.hutool.core.io.file.FileWriter
import com.alibaba.fastjson2.JSONArray
import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.JSONWriter
import java.io.File

object FileUtil : FileUtil() {
    /**
     * JSONObject写入文件
     *
     * @param file       文件
     * @param jsonObject JSONObject
     */
    fun File.writerJSONObject(jsonObject: JSONObject) {
        val writer = FileWriter(this)
        writer.write(jsonObject.toJSONString(JSONWriter.Feature.PrettyFormat))
    }

    /**
     * JSONArray写入文件
     *
     * @param jsonArray JSONArray
     */
    fun File.writerJSONArray( jsonArray: JSONArray) {
        val writer = FileWriter(this)
        writer.write(jsonArray.toJSONString(JSONWriter.Feature.PrettyFormat))
    }

    /**
     * 从文件读取JSONObject
     *
     */
    fun File.readJSONObject(): JSONObject {
        val fileReader = FileReader(this)
        return JSONObject.parseObject(fileReader.readString())
    }

    /**
     * 从文件读取JSONArray
     *
     */
    fun File.readJSONArray(): JSONArray {
        val fileReader = FileReader(this)
        return JSONArray.parseArray(fileReader.readString())
    }
}
