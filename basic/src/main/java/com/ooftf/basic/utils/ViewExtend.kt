package com.ooftf.basic.utils

import android.view.View
import android.view.ViewGroup

/**
 *
 * @author ooftf`
 * @email 994749769@qq.com
 * @date 2020/9/23
 */
fun View.inflate(layoutId: Int, parent: ViewGroup? = null, isAttach: Boolean = false): View {
    return context.inflate(layoutId, parent, isAttach)
}