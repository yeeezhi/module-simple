package me.yeezhi.common

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.IsoFields

/**
 * 获取今天的唯一标识符
 */
fun todayId(): String {
    val today = LocalDate.now()
    return today.format(DateTimeFormatter.BASIC_ISO_DATE)
}

/**
 * 获取本周的唯一标识符（使用年和ISO周编号）
 */
fun weekId(): String {
    val today = LocalDate.now()
    return today.year.toString() + "-W" + today.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)
}

/**
 * 获取本月的唯一标识符（使用年和月份）
 */
fun monthId(): String {
    val today = LocalDate.now()
    return today.format(DateTimeFormatter.ofPattern("yyyy-MM"))
}