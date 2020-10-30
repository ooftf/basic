package com.ooftf.basic.engine.serializable

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/7/1
 */
abstract class SerializableFloat : Serializable<Float>() {
    override fun getSerializable(): Float {
        return sp.getFloat(getKey(), getDefaultValue())
    }

    override fun setSerializable(value: Float) {
        sp.edit().putFloat(getKey(), value).apply()
    }

    override fun getDefaultValue() = 0.0f
}