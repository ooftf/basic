package com.ooftf.basic.widget

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewPro : RecyclerView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        itemAnimator = null
        overScrollMode = OVER_SCROLL_NEVER
    }
}