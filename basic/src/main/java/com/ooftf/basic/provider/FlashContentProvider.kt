package com.ooftf.basic.provider

import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import com.ooftf.basic.AppHolder
import com.ooftf.basic.engine.ActivityManager
/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/23
 */
class FlashContentProvider : ContentProvider() {
    override fun onCreate(): Boolean {
        AppHolder.app = (context as Application?)!!
        ActivityManager.init(AppHolder.app)
        return false
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        return null
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        return 0
    }
}