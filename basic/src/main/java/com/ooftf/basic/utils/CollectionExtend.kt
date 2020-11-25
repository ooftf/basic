package com.ooftf.basic.utils


/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/11/25
 */
fun <T> MutableList<T>.removeIf_(filter: (T) -> Boolean) {
    var i = 0
    while (i < size) {
        val item = this[i]
        if (filter(item)) {
            this.remove(item)
        } else {
            i++
        }
    }
}