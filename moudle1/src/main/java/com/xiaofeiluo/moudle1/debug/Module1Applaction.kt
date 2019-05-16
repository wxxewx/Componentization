package com.xiaofeiluo.moudle1.debug

import android.app.Application
import android.util.Log

class Module1Applaction :  Application()  {


    override fun onCreate() {
        super.onCreate()
        Log.e("Module1Applaction","Module1初始化完成")
    }

}