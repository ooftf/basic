package com.ooftf.basic.utils

import android.R
import android.graphics.Point
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DimenRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.roundToInt

/**
 *
 * @author ooftf`
 * @email 994749769@qq.com
 * @date 2020/9/23
 *
 */
fun View.inflate(layoutId: Int, parent: ViewGroup? = null, isAttach: Boolean = false): View {
    return context.inflate(layoutId, parent, isAttach)
}

fun View.setPadding(paddingPx: Int) {
    setPadding(paddingPx, paddingPx, paddingPx, paddingPx)
}

fun View.setPaddingLeft(paddingPx: Int) {
    setPadding(paddingPx, paddingTop, paddingRight, paddingBottom)
}

fun View.setPaddingTop(paddingPx: Int) {
    setPadding(paddingLeft, paddingPx, paddingRight, paddingBottom)
}

fun View.setPaddingRight(paddingPx: Int) {
    setPadding(paddingLeft, paddingTop, paddingPx, paddingBottom)
}

fun View.setPaddingBottom(paddingPx: Int) {
    setPadding(paddingLeft, paddingTop, paddingRight, paddingPx)
}

fun View.setPaddingVertical(paddingPx: Int) {
    setPadding(paddingLeft, paddingPx, paddingRight, paddingPx)
}

fun View.setPaddingHorizontal(paddingPx: Int) {
    setPadding(paddingPx, paddingTop, paddingPx, paddingBottom)
}


fun View.setPaddingRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingPx, paddingPx, paddingPx, paddingPx)
}

fun View.setPaddingLeftRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingPx, paddingTop, paddingRight, paddingBottom)
}

fun View.setPaddingTopRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingLeft, paddingPx, paddingRight, paddingBottom)
}

fun View.setPaddingRightRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingLeft, paddingTop, paddingPx, paddingBottom)
}

fun View.setPaddingBottomRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingLeft, paddingTop, paddingRight, paddingPx)
}

fun View.setPaddingVerticalRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingLeft, paddingPx, paddingRight, paddingPx)
}

fun View.setPaddingHorizontalRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingPx, paddingTop, paddingPx, paddingBottom)
}

/**
 * 可见部分在整个屏幕中所处的位置
 * 包含titleBar所占位置
 *
 * getGlobalVisibleRect 方法获取的是相对于 Window 的值，Rect是可视范围，Point 是左上角坐标（包含不可视部分）
 */
fun View.getVisibleRectOfScreen(): Rect {
    return Rect().apply {
        val p = Point()
        getGlobalVisibleRect(this, p)
        val locations = IntArray(2)
        getLocationOnScreen(locations)
        offset(locations[0] - p.x, locations[1] - p.y)
    }
}

fun View.getVisibleRectOfWindow(): Rect {
    return Rect().apply {
        getGlobalVisibleRect(this)
    }
}

/**
 * （自身可见部分）处于（自身）的位置
 */
fun View.getVisibleRectOfSelf(): Rect {
    return Rect().apply {
        getLocalVisibleRect(this)
    }
}

fun View.postLayoutComplete(action: () -> Unit) {
    if (height != 0 || width != 0) {
        action.invoke()
    } else {
        post {
            postLayoutComplete(action)
        }
    }
}

fun View.findAttachedFragment(): Fragment? {
    this.context.getFragmentActivity()?.let {
        val map = HashMap<View, Fragment>()
        findAllSupportFragmentsWithViews(it.supportFragmentManager.fragments, map)
        var result: Fragment? = null
        val activityRoot: View = it.findViewById<View>(R.id.content)
        var current: View = this
        while (current != activityRoot) {
            result = map[current]
            if (result != null) {
                break
            }
            current = if (current.parent is View) {
                current.parent as View
            } else {
                break
            }
        }
        return result
    }
    return null
}

fun View.findAttachedLifecycleOwner(): LifecycleOwner? {
    this.findAttachedFragment()?.let {
        return it
    }
    this.context.getActivity()?.let {
        if (it is LifecycleOwner) {
            return it
        }
    }
    return null
}

private fun findAllSupportFragmentsWithViews(
    topLevelFragments: Collection<Fragment>?,
    result: MutableMap<View, Fragment>
) {
    if (topLevelFragments == null) {
        return
    }
    for (fragment in topLevelFragments) {
        // getFragment()s in the support FragmentManager may contain null values, see #1991.
        val key = fragment.view
        if (key == null) {
            continue
        } else {
            result[key] = fragment
            findAllSupportFragmentsWithViews(fragment.childFragmentManager.fragments, result)
        }

    }
}

private val idGen = AtomicInteger(0x02000000)
fun genTagId(): Int {//0x02000000..0x7FFFFFFF
    val andIncrement = idGen.getAndIncrement()
    if (andIncrement == Int.MAX_VALUE) {
        idGen.set(0x02000000)
    }
    return andIncrement
}
