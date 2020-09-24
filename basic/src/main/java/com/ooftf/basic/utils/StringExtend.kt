package com.ooftf.basic.utils

import org.json.JSONException
import org.json.JSONObject
import java.text.DecimalFormat
import java.util.*

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/23
 */


fun String?.isInt(): Boolean {
    if (isNullOrBlank()) {
        return false
    }
    return toIntOrNull() != null
}

fun String?.toIntOrDefault(defaultValue: Int = 0): Int {
    if (isNullOrBlank()) {
        return defaultValue
    }
    return toIntOrNull() ?: defaultValue
}

fun String?.toIntOrDefaultSafe(defaultValue: Int = 0): Int {
    if (isNullOrBlank()) {
        return defaultValue
    }
    val newStr = replace(Regex("[^\\d]*"), "")
    return newStr.toIntOrNull() ?: defaultValue
}


fun String?.isDouble(): Boolean {
    if (isNullOrBlank()) {
        return false
    }
    return toDoubleOrNull() != null
}

fun String?.toDoubleOrDefault(defaultValue: Double = 0.0): Double {
    if (isNullOrBlank()) {
        return defaultValue
    }
    return toDoubleOrNull() ?: defaultValue
}

fun String?.toDoubleOrDefaultSafe(defaultValue: Double = 0.0): Double {
    if (isNullOrBlank()) {
        return defaultValue
    }
    val newStr = replace(Regex("[^\\d.]*"), "")
    return newStr.toDoubleOrNull() ?: defaultValue
}


fun String?.numFormat(pattern: String): String {
    return DecimalFormat(pattern).format(toDoubleOrDefault())
}

fun String?.numFormat2(): String {
    return DecimalFormat("0.00").format(toDoubleOrDefault())
}

fun String?.numFormat2D(): String {
    return DecimalFormat(",###.00").format(toDoubleOrDefault())
}

/**
 * 判断是否是json格式
 *
 * @param string
 * @return
 */
fun String?.isJson(): Boolean {
    if (isNullOrBlank()) {
        return false
    }
    return try {
        JSONObject(this)
        true
    } catch (e: JSONException) {
        false
    }
}

/**
 * 将数字 填充为两位字符串
 *
 * @param src
 * @return
 */
fun zeroPaddingToDouble(src: String): String {
    return if (src.length > 1) {
        src
    } else if (src.length == 1) {
        "0$src"
    } else {
        "00"
    }
}

/**
 * 将数字补成两位字符串
 *
 * @param src
 * @return
 */
fun zeroPaddingToDouble(src: Int): String {
    return zeroPaddingToDouble(src.toString())
}

fun listToString(
    list: List<*>?,
    splitCharacter: String
): String {
    if (list == null) {
        return ""
    }
    var result = ""
    for (i in list.indices) {
        if (i == list.size - 1) {
            result += list[i]
        } else {
            result += list[i]?.toString() ?: "" + splitCharacter
        }
    }
    return result
}


fun String.split(perLength: Int): List<String> {
    val list: MutableList<String> =
        ArrayList()
    var i = 0
    while (i < length) {
        val end = length.coerceAtMost(i + perLength)
        list.add(substring(i, end))
        i = end
    }
    return list
}