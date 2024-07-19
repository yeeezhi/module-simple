package me.yeezhi.common.util

import java.util.regex.Pattern

/**
 * 字符串工具
 */
object StringUtil {
    /**
     * 字符串替换占位符
     * @param placeholder 占位符数据
     */
    fun String.replace(placeholder: MutableMap<String, String>): String {
        var str = this
        placeholder.forEach { (key, value) -> str = str.replace(key, value) }
        return str
    }

    /**
     * 字符串替换占位符
     * @param placeholder 占位符数据
     */
    fun List<String>.replace(placeholder: MutableMap<String, String>): List<String> {
        return this.map { it.replace(placeholder) }
    }


    /**
     * 获得字符串中的数值
     *
     * @param str 字符串
     * @return 数值
     */
    fun getNumber(str: String): String {
        val str: String = str.replace("§+[a-z0-9]".toRegex(), "").replace("[^-0-9.]".toRegex(), "")
        return if (str.isNotEmpty() && str.replace("[^.]".toRegex(), "").length <= 1) str else "0"
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str 字符串
     * @return true 为数字,false 则不全是数字
     */
    fun isNumber(str: String): Boolean {
        return Pattern.compile("\\d*").matcher(str).matches()
    }

}