package com.ooftf.basic.engine.serializable

import android.widget.CompoundButton

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/7/1
 */
abstract class SerializableBoolean : Serializable<Boolean>() {
    override fun getSerializable(): Boolean {
        return sp.getBoolean(getKey(), getDefaultValue())
    }

    override fun setSerializable(value: Boolean) {
        sp.edit().putBoolean(getKey(), value).apply()
    }

    override fun getDefaultValue() = false

    fun bind(v: CompoundButton, listener: CompoundButton.OnCheckedChangeListener? = null) {
        v.isChecked = get()
        v.setOnCheckedChangeListener { buttonView, isChecked ->
            set(isChecked)
            listener?.onCheckedChanged(buttonView, isChecked)
        }
    }
}