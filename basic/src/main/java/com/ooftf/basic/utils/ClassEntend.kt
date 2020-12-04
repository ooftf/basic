package com.ooftf.basic.utils

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/12/4
 */
fun Any.getGenericParamType(position: Int): Type? {
    (javaClass.genericSuperclass as? ParameterizedType)?.let {
        it.actualTypeArguments.let {
            if (it.size > position) {
                return it[position]
            }
        }
    }
    return null
}