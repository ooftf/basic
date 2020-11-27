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
    val first = layoutManager.findFirstCompletelyVisibleItemPosition()
    val last = layoutManager.findLastCompletelyVisibleItemPosition()
    if (position < first || position > last) {
        if (scrollState == RecyclerView.SCROLL_STATE_IDLE) {
            smoothScrollToPosition(position)
            post {
                scrollPositionToCenter(position)
            }
        } else {
            post {
                scrollPositionToCenter(position)
            }
        }
    } else {
        val findViewByPosition = layoutManager.findViewByPosition(position) ?: return
        if (layoutManager.orientation == RecyclerView.VERTICAL) {
            val dy = findViewByPosition.getVisibleRectOfScreen()
                .centerY() - getVisibleRectOfScreen().centerY()
            smoothScrollBy(
                0,
                dy
            )
        } else {
            val dx = findViewByPosition.getVisibleRectOfScreen()
                .centerX() - getVisibleRectOfScreen().centerX()
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
    val first = layoutManager.findFirstCompletelyVisibleItemPosition()
    val last = layoutManager.findLastCompletelyVisibleItemPosition()
    if (position < first || position > last) {
        if (scrollState == RecyclerView.SCROLL_STATE_IDLE) {
            smoothScrollToPosition(position)
            post {
                scrollPositionToFirst(position)
            }
        } else {
            post {
                scrollPositionToFirst(position)
            }
        }
    } else {
        val findViewByPosition = layoutManager.findViewByPosition(position) ?: return
        if (layoutManager.orientation == RecyclerView.VERTICAL) {
            val dy =
                findViewByPosition.getVisibleRectOfScreen().top - getVisibleRectOfScreen().top
            smoothScrollBy(
                0,
                dy
            )
        } else {
            val dx =
                findViewByPosition.getVisibleRectOfScreen().left - getVisibleRectOfScreen().left
            smoothScrollBy(
                dx,
                0
            )
        }

    }
}