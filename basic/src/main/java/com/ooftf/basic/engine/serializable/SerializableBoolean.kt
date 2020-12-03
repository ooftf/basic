package com.ooftf.basic.engine.serializable

import android.view.View
import android.widget.Checkable

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

    fun bind(v: Checkable) {
        v.isChecked = get()
        (v as? View)?.let {
            it.setOnClickListener {
                set(v.isChecked)
            }
        }
    }
}