package com.ooftf.basic.utils

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2021/1/6
 */
/**
 * 为什么有Any了还要传入Class<*>？
 * 因为Class<*>有可能是Any的父类，子类class无法反射出父类的 Field和Method
 */
fun Any.reflectGetField(fieldName: String, clz: Class<*>? = null): Any? {
    try {
        val clazz = clz ?: this::class.java
        clazz.getDeclaredField(fieldName).let {
            it.isAccessible = true
            return it.get(this)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun <T> Class<T>.reflectClassGetField(fieldName: String, obj: T? = null): Any? {
    try {
        this.getDeclaredField(fieldName).let {
            it.isAccessible = true
            return it.get(obj)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun Any.reflectSetField(fieldName: String, value: Any?, clz: Class<*>? = null): Boolean {
    try {
        val clazz = clz ?: this::class.java
        clazz.getDeclaredField(fieldName).let {
            it.isAccessible = true
            it.set(this, value)
            return true
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return false
}

fun <T> Class<T>.reflectClassSetField(fieldName: String, value: Any?, obj: T? = null): Boolean {
    try {
        this.getDeclaredField(fieldName).let {
            it.isAccessible = true
            it.set(obj, value)
            return true
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return false
}

/**
 * 反射无参方法
 */
fun Any.reflectMethod(methodName: String, clz: Class<*>? = null): Any? {
    return try {
        val clazz = clz ?: this::class.java
        val method = clazz.getDeclaredMethod(methodName)
        method.isAccessible = true
        method.invoke(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

/**
 * 反射无参方法
 */
fun <T> Class<T>.reflectClassMethod(methodName: String, obj: T? = null): Any? {
    return try {
        val method = this.getDeclaredMethod(methodName)
        method.isAccessible = true
        method.invoke(obj)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}