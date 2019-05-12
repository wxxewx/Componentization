package com.xiaofeiluo.moudle3

import android.app.Application
import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaofeiluo.base.IAppInit
import com.xiaofeiluo.router.module3AppInit

@Route(path = module3AppInit)
class Module3Applaction : IAppInit {

    override fun initApp(applaction: Application) {
        Log.e("Module3Applaction","initApp")
    }


    override fun init(context: Context) {

    }
}
