package com.ooftf.basic.engine.serializable

import android.content.Context
import com.ooftf.basic.AppHolder

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/7/1
 */
abstract class SerializableBoolean: Serializable<Boolean>() {
    override fun getSerializable(): Boolean {
       return  sp.getBoolean(getKey(), getDefaultValue())
    }
    override fun setSerializable(value: Boolean) {
        sp.edit().putBoolean(getKey(), value).apply()
    }
    override fun getDefaultValue() = false
}