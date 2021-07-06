package com.ooftf.basic.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/11/27
 */
fun RecyclerView.scrollPositionToCenter(position: Int) {
    val itemCount = adapter?.itemCount
    if (itemCount == null || position < 0 || position >= itemCount) {
        return
    }
    val layoutManager = (layoutManager as? LinearLayoutManager) ?: return
    val findViewByPosition = layoutManager.findViewByPosition(position)
    if (findViewByPosition == null) {
        this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (layoutManager.findViewByPosition(position) != null) {
                    removeOnScrollListener(this)
                    scrollPositionToCenter(position)
                }
            }
        })
        smoothScrollToPosition(position)
    } else {
        if (layoutManager.orientation == RecyclerView.VERTICAL) {
            val dy =
                (findViewByPosition.top + findViewByPosition.bottom) / 2 - (paddingTop + (height - paddingBottom)) / 2
            smoothScrollBy(
                0,
                dy
            )
        } else {
            val dx =
                (findViewByPosition.left + findViewByPosition.right) / 2 - (paddingLeft + (width - paddingRight)) / 2
            smoothScrollBy(
                dx,
                0
            )
        }
    }

}

fun RecyclerView.scrollPositionToFirst(position: Int) {
    val itemCount = adapter?.itemCount
    if (itemCount == null || position < 0 || position >= itemCount) {
        return
    }
    val layoutManager = (layoutManager as? LinearLayoutManager) ?: return
    val findViewByPosition = layoutManager.findViewByPosition(position)
    if (findViewByPosition == null) {
        this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (layoutManager.findViewByPosition(position) != null) {
                    removeOnScrollListener(this)
                    scrollPositionToFirst(position)
                }
            }
        })
        smoothScrollToPosition(position)
    } else {
        if (layoutManager.orientation == RecyclerView.VERTICAL) {
            smoothScrollBy(
                0,
                findViewByPosition.top - paddingTop
            )
        } else {
            smoothScrollBy(
                findViewByPosition.left - paddingLeft,
                0
            )
        }
    }
}