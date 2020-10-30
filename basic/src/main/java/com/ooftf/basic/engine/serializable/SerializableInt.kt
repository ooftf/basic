package com.ooftf.basic.engine.serializable

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/7/1
 */
abstract class SerializableInt : Serializable<Int>() {
    override fun getSerializable(): Int {
        return sp.getInt(getKey(), getDefaultValue())
    }

    override fun setSerializable(value: Int) {
        sp.edit().putInt(getKey(), value).apply()
    }

    override fun getDefaultValue() = 0
}