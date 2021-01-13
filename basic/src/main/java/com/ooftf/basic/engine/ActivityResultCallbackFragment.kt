package com.ooftf.basic.engine

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/12/30
 */
class ActivityResultCallbackFragment : Fragment() {
    var action: ((requestCode: Int, resultCode: Int, data: Intent?) -> Unit)? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        action?.invoke(requestCode, resultCode, data)
        this.action = null
        parentFragmentManager.beginTransaction().remove(this).commitNowAllowingStateLoss()
    }

    fun setResultAction(action: (requestCode: Int, resultCode: Int, data: Intent?) -> Unit) {
        this.action = action
    }

    companion object {
        val TAG = ActivityResultCallbackFragment::class.java.name
        fun start(
            manager: FragmentManager,
            onFragmentCreate: (Fragment) -> Unit,
            action: (requestCode: Int, resultCode: Int, data: Intent?) -> Unit
        ) {
            var fragment = manager.findFragmentByTag(TAG)
            if (fragment == null) {
                fragment = ActivityResultCallbackFragment()
                manager.beginTransaction().add(fragment, TAG).commitNowAllowingStateLoss()
            }
            (fragment as ActivityResultCallbackFragment).setResultAction(action)
            onFragmentCreate.invoke(fragment)
        }

        fun start(
            activity: FragmentActivity,
            onFragmentCreate: (Fragment) -> Unit,
            action: (requestCode: Int, resultCode: Int, data: Intent?) -> Unit
        ) {

            start(activity.supportFragmentManager, onFragmentCreate, action)
        }

        fun start(
            fragment: Fragment,
            onFragmentCreate: (Fragment) -> Unit,
            action: (requestCode: Int, resultCode: Int, data: Intent?) -> Unit
        ) {
            start(fragment.childFragmentManager, onFragmentCreate, action)
        }

        fun start(
            onFragmentCreate: (Fragment) -> Unit,
            action: (requestCode: Int, resultCode: Int, data: Intent?) -> Unit
        ) {
            (ActivityManager.getTopActivity() as? FragmentActivity)?.let {
                start(it.supportFragmentManager, onFragmentCreate, action)
            }
        }
    }
}
