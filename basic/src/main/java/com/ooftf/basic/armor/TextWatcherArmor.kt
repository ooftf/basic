package com.ooftf.basic.armor

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/1/6
 */
open class TextWatcherArmor(
    var textView: TextView? = null,
    var afterTextChanged: ((TextWatcherArmor, Editable) -> Unit)? = null,
    var beforeTextChanged: ((TextWatcherArmor, CharSequence, start: Int, count: Int, after: Int) -> Unit)? = null,
    var onTextChanged: ((TextWatcherArmor, CharSequence, start: Int, before: Int, count: Int) -> Unit)? = null
) : TextWatcher {
    override fun afterTextChanged(s: Editable) {
        afterTextChanged?.invoke(this, s)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        beforeTextChanged?.invoke(this, s, start, count, after)
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        onTextChanged?.invoke(this, s, start, before, count)
    }

    fun setText(text: String) {
        textView?.run {
            removeTextChangedListener(this@TextWatcherArmor)
            setText(text)
            addTextChangedListener(this@TextWatcherArmor)
        }

    }
}