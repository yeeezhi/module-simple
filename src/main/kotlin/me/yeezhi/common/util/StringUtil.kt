package me.yeezhi.common.util

import java.util.*
import java.util.regex.Pattern
import java.util.stream.Collectors
import kotlin.math.min

/**
 * 字符串工具
 */
object StringUtil {
    /**
     * 是否为空
     *
     * @param str 字符串
     * @return true/是
     */
    fun isEmpty(str: CharSequence?): Boolean {
        return str.isNullOrEmpty()
    }

    /**
     * 是否不为空
     *
     * @param str 字符串
     * @return true/是
     */
    fun isNotEmpty(str: CharSequence?): Boolean {
        return !isEmpty(str)
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

    /**
     * 转换小写
     *
     * @param str 字符串
     * @return 小写字符串
     */
    fun toLowerCase(str: String?): String? {
        return str?.lowercase(Locale.getDefault())
    }

    /**
     * 将#替换成空格
     *
     * @param str 字符串
     * @return 替换后的字符串
     */
    fun replaceSpace(str: String): String {
        return if (isEmpty(str)) {
            str
        } else str.replace("#", " ")
    }

    /**
     * 字符串转集合
     *
     * @param str 字符串
     * @return 集合
     */
    fun strToStrList(str: String): List<String> {
        val list: List<String> = ArrayList()
        return if (isEmpty(str)) {
            list
        } else Arrays.stream(str.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
            .map { obj: String -> obj.trim { it <= ' ' } }.collect(Collectors.toList())
    }

    /**
     * 字符串转集合
     *
     * @param str 字符串
     * @return 集合
     */
    fun strToLongList(str: String): List<Long> {
        val list: List<Long> = ArrayList()
        return if (isEmpty(str)) {
            list
        } else Arrays.stream(str.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
            .map { s: String -> s.trim { it <= ' ' }.toLong() }.collect(Collectors.toList())
    }

    /**
     * 字符串转集合
     *
     * @param str 字符串
     * @return 集合
     */
    fun strToIntList(str: String): List<Int> {
        val list: List<Int> = ArrayList()
        return if (isEmpty(str)) {
            list
        } else Arrays.stream(str.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
            .map { s: String -> s.trim { it <= ' ' }.toInt() }.collect(Collectors.toList())
    }

    /**
     * 去除字符串中所有的空白符
     *
     * @param str 字符串
     * @return 新字符串
     * @since 3.1.0
     */
    fun deleteWhitespace(str: String): String {
        if (isEmpty(str)) {
            return str
        }
        val sz = str.length
        val chs = CharArray(sz)
        var count = 0
        for (i in 0 until sz) {
            if (!Character.isWhitespace(str[i])) {
                chs[count++] = str[i]
            }
        }
        return if (count == sz) {
            str
        } else {
            String(chs, 0, count)
        }
    }

    /**
     * 版本比较
     *
     * @param version1 当前版本
     * @param version2 要求版本
     * @return 0 等于,-1小于,1大于
     */
    fun compareVersion(version1: String, version2: String): Int {
        if (version1 == version2) {
            return 0
        }
        val version1Array = version1.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val version2Array = version2.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        var index = 0
        //获取最小长度值
        val minLen = min(version1Array.size.toDouble(), version2Array.size.toDouble()).toInt()
        var diff = 0
        //循环判断每位的大小
        while (index < minLen && (version1Array[index].toInt() - version2Array[index].toInt()).also {
                diff = it
            } == 0) {
            index++
        }
        return if (diff == 0) {
            //如果位数不一致，比较多余位数
            for (i in index until version1Array.size) {
                if (version1Array[i].toInt() > 0) {
                    return 1
                }
            }
            for (i in index until version2Array.size) {
                if (version2Array[i].toInt() > 0) {
                    return -1
                }
            }
            0
        } else {
            if (diff > 0) 1 else -1
        }
    }
}