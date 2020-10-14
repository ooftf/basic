package com.ooftf.basic.utils

import android.content.Context
import com.ooftf.basic.AppHolder
import io.reactivex.rxjava3.core.Observable
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

/**
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/2/6
 */
object AssetUtil {
    /**
     * name "protocol.txt"
     * 如果出现异常返回值为 "" 空字符串
     */
    fun readAssertResource(name: String): Observable<String> {
        return Observable.fromCallable {
            readAssertResource(AppHolder.app, name)
        }
    }

    fun readAssertResource(context: Context, strAssertFileName: String): String {
        val assetManager = context.assets
        var strResponse = ""
        try {
            val ims = assetManager.open(strAssertFileName)
            strResponse = getStringFromInputStream(ims)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return strResponse
    }

    private fun getStringFromInputStream(a_is: InputStream): String {
        var br: BufferedReader? = null
        val sb = StringBuilder()
        var line: String?
        try {
            br = BufferedReader(InputStreamReader(a_is))
            while (br.readLine().also { line = it } != null) {
                sb.append(line)
            }
        } catch (e: IOException) {
        } finally {
            if (br != null) {
                try {
                    br.close()
                } catch (e: IOException) {
                }
            }
        }
        return sb.toString()
    }
}