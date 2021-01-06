package com.ooftf.basic.utils

import androidx.lifecycle.LiveData

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2021/1/5
 */
fun LiveData<*>.reflectGetVersion(): Int {
    return this.reflectMethod("getVersion", LiveData::class.java) as Int
}

fun getLiveData_START_VERSION(): Int {
    return LiveData::class.java.reflectClassGetField("START_VERSION") as Int
}