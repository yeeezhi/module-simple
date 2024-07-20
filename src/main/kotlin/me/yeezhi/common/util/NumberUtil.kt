package me.yeezhi.common.util

import kotlin.math.pow

object NumberUtil {
    /**
     * 获取double的小数位数
     */
    fun Double.decimalDigits(): Int {
        if (this == this.toLong().toDouble()) {
            return 0
        }
        var i = 0
        while (true) {
            i++
            if (this * 10.0.pow(i) % 1 == 0.0) {
                return i
            }
        }
    }

    /**
     * 格式化double
     *@param maxDecimalDigits 最大小数位数
     */
    fun Double.format(maxDecimalDigits: Int = 2): String {
        var decimalDigits = this.decimalDigits()
        if (decimalDigits > maxDecimalDigits) {
            decimalDigits = 2
        }
        return String.format("%.${decimalDigits}f", this)
    }
}