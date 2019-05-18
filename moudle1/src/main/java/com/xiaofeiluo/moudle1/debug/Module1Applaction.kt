package com.xiaofeiluo.moudle1.debug

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.xiaofeiluo.moudle1.BuildConfig

class Module1Applaction :  Application()  {


    override fun onCreate() {
        super.onCreate()
        initRouter()
        Log.e("Module1Applaction","Module1初始化完成")
    }
    private fun initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}