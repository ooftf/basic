package com.ooftf.basic.engine.serializable

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ooftf.basic.utils.getGenericParamType
import java.lang.reflect.ParameterizedType

/**
 *
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/6/10
 */
abstract class SerializableObject<T> : Serializable<T>() {
    val gson = createGson()
    open fun createGson() = Gson()
    override fun getKey(): String {
        return javaClass.name
    }

    override fun getSerializable(): T {
        val json = sp.getString(getKey(), null)
        return if (json == null) {
            getDefaultValue()
        } else {
            try {
                val genericParamType = this.getGenericParamType(0)
                gson.fromJson(json, genericParamType)
            } catch (e: Exception) {
                e.printStackTrace()
                getDefaultValue()
            }

        }

    }

    override fun setSerializable(value: T) {
        sp.edit().putString(getKey(), gson.toJson(value)).apply()
    }

    open fun sync() {
        setSerializable(get())
    }
}