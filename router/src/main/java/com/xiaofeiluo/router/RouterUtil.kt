package com.xiaofeiluo.router


import android.support.v4.app.Fragment
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import kotlin.concurrent.thread


object RouterUtil {

    fun getFragment(path: String): Fragment? {
        val fragment = ARouter.getInstance().build(path).navigation()
        return if (fragment != null) {
            fragment as Fragment
        } else {
            Log.e("getFragment", "can't  find this fragment")
            null
        }

    }
}