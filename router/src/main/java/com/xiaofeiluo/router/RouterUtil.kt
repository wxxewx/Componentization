package com.xiaofeiluo.router


import android.support.v4.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter



object RouterUtil{

    fun getFragment(path:String): Fragment {
        val fragment = ARouter.getInstance().build(path).navigation() as Fragment
        return fragment
    }
}