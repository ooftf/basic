package com.ooftf.basic.engine.serializable

import android.content.Context
import com.ooftf.basic.AppHolder

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/7/1
 */
abstract class Serializable<T> {
    val SP_NAME = "SERIALIZABLE_SWITCH_KEY_NAME_${this::class.java.name}"
    val sp by lazy {
        AppHolder.app.getSharedPreferences(
            SP_NAME,
            Context.MODE_PRIVATE
        )
    }
    private var value: T? = null
    fun get(): T {
        if (value == null) {
            value = getSerializable()
        }
        return value ?: getDefaultValue()
    }

    abstract fun getSerializable(): T

    fun set(value: T) {
        if (this.value == value) {
            return
        }
        this.value = value
        setSerializable(value)
    }

    abstract fun setSerializable(value: T)

    abstract fun getKey(): String
    abstract fun getDefaultValue(): T
}