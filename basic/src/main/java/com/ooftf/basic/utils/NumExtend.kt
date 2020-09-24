package com.ooftf.basic.utils

import java.text.DecimalFormat

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/24
 */

fun Double.format(pattern: String): String {
    return DecimalFormat(pattern).format(this)
}

fun Float.format(pattern: String): String {
    return DecimalFormat(pattern).format(this.toDouble())
}

fun Int.format(pattern: String): String {
    return DecimalFormat(pattern).format(this.toLong())
}

fun Long.format(pattern: String): String {
    return DecimalFormat(pattern).format(this)
}