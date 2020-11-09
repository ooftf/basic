package com.ooftf.basic.action

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/11/9
 */
interface Action<T> {
    operator fun invoke(t: T)
}