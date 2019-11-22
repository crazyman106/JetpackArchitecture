@file:JvmName("Converter")

package com.test.databinding_twoways.util

import kotlin.math.round

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/11/18 0018
 *  @pkn    : com.test.databinding_twoways.util
 *  @desc   :
 */


/**
 * %.0f表示不输出小数位,但要对第一位小数进行四舍五入;%.1f表示保留一位小数,对第二位小数进行四舍五入
 */
fun fromTenthsToSeconds(tenths: Int): String {
    return if (tenths < 600) {
        String.format("%.1f", tenths / 10.0)
    } else {
        val minutes = (tenths / 10) / 60
        val seconds = (tenths / 10) % 60
        String.format("%d:%02d", minutes, seconds)
    }
}

fun cleanSecondsString(seconds: String): Int {
    // Remove letters and other characters
    val filteredValue = seconds.replace(Regex("""[^\d:.]"""), "")
    if (filteredValue.isEmpty()) return 0
    val elements: List<Int> = filteredValue.split(":").map { it -> round(it.toDouble()).toInt() }
    var result: Int
    return when {
        elements.size > 2 -> 0
        elements.size > 1 -> {
            result = elements[0] * 60
            result += elements[1]
            result * 10
        }
        else -> elements[0] * 10
    }
}