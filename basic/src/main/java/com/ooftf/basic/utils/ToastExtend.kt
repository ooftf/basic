package com.ooftf.basic.utils

import android.content.Context
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import com.ooftf.basic.AppHolder
import com.ooftf.basic.R
import java.lang.ref.WeakReference

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/23
 */
var toastGravity: Int = Gravity.BOTTOM
var toastWeakReference: WeakReference<Toast>? = null
var toastText: CharSequence? = null
fun toast(
    message: CharSequence,
    context: Context = AppHolder.app,
    duration: Int = Toast.LENGTH_SHORT,
    gravity: Int = toastGravity
) {
    val toast = Toast.makeText(context, message, duration)
    if (gravity != Gravity.BOTTOM) {
        toast.setGravity(gravity, 0, 0)
    }
    if (message == toastText) {
        toastWeakReference?.get()?.cancel()
    }
    toast.show()
    toastText = message
    toastWeakReference = WeakReference<Toast>(toast)
}

fun toastCenter(
    message: CharSequence,
    context: Context = AppHolder.app,
    duration: Int = Toast.LENGTH_SHORT
) {
    toast(message, context, duration, Gravity.CENTER)
}

fun toastBottom(
    message: CharSequence,
    context: Context = AppHolder.app,
    duration: Int = Toast.LENGTH_SHORT
) {
    toast(message, context, duration, Gravity.BOTTOM)
}

fun toastSuccess(
    message: CharSequence, context: Context = AppHolder.app,
    duration: Int = Toast.LENGTH_SHORT,
    gravity: Int = Gravity.CENTER
) {
    toastImg(message, R.drawable.basic_ooftf_vector_success, context, duration, gravity)
}

fun toastError(
    message: CharSequence, context: Context = AppHolder.app,
    duration: Int = Toast.LENGTH_SHORT,
    gravity: Int = Gravity.CENTER
) {
    toastImg(message, R.drawable.basic_ooftf_vector_error, context, duration, gravity)
}

fun toastWarn(
    message: CharSequence, context: Context = AppHolder.app,
    duration: Int = Toast.LENGTH_SHORT,
    gravity: Int = Gravity.CENTER
) {
    toastImg(message, R.drawable.basic_ooftf_vector_warn, context, duration, gravity)
}

fun toastImg(
    message: CharSequence,
    @DrawableRes imgId: Int,
    context: Context = AppHolder.app,
    duration: Int = Toast.LENGTH_SHORT,
    gravity: Int = toastGravity
) {
    Toast(context).apply {
        view = AppHolder.app.inflate(R.layout.basic_ooftf_toast_img)
        view.findViewById<TextView>(R.id.text).text = message
        view.findViewById<ImageView>(R.id.img).setImageResource(imgId)
        setDuration(duration)
        setGravity(gravity, 0, 0)
        show()
    }
}