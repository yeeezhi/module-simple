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
    fun writerJSONObject(file: File?, jsonObject: JSONObject) {
        val writer = FileWriter(file)
        writer.write(jsonObject.toJSONString(JSONWriter.Feature.PrettyFormat))
    }

    /**
     * JSONArray写入文件
     *
     * @param file      文件
     * @param jsonArray JSONArray
     */
    fun writerJSONArray(file: File?, jsonArray: JSONArray) {
        val writer = FileWriter(file)
        writer.write(jsonArray.toJSONString(JSONWriter.Feature.PrettyFormat))
    }

    /**
     * 从文件读取JSONObject
     *
     * @param file 文件
     */
    fun readJSONObject(file: File?): JSONObject {
        val fileReader = FileReader(file)
        return JSONObject.parseObject(fileReader.readString())
    }

    /**
     * 从文件读取JSONArray
     *
     * @param file 文件
     */
    fun readJSONArray(file: File?): JSONArray {
        val fileReader = FileReader(file)
        return JSONArray.parseArray(fileReader.readString())
    }
}
