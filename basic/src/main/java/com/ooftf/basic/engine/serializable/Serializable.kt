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
    private val SP_NAME = "SERIALIZABLE_SWITCH_KEY_NAME_${this::class.java.name}"
    protected val sp by lazy {
        AppHolder.app.getSharedPreferences(
            SP_NAME,
            Context.MODE_PRIVATE
        )
    }
    private var value: T? = null
    fun get(): T {
        if (value == null) {
            try {
                value = getSerializable()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return value ?: getDefaultValue()
    }

    protected abstract fun getSerializable(): T

    fun set(value: T) {
        if (this.value == value) {
            return
        }
        this.value = value
        setSerializable(value)
    }

    protected abstract fun setSerializable(value: T)

    abstract fun getKey(): String
    abstract fun getDefaultValue(): T

    fun clear() {
        value = null
        clearSerializable()
    }

    fun clearSerializable() {
        sp.edit().remove(getKey()).apply()
    }
}