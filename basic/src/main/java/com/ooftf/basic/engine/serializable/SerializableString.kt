package com.ooftf.basic.engine.serializable

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/7/1
 */
abstract class SerializableString : Serializable<String>() {
    override fun getSerializable(): String {
        return sp.getString(getKey(), getDefaultValue()) ?: getDefaultValue()
    }

    override fun setSerializable(value: String) {
        sp.edit().putString(getKey(), value).apply()
    }

    override fun getDefaultValue() = ""
}