package com.xiaofeiluo.moudle2

import android.app.Application
import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaofeiluo.router.applaction.AppModules
import com.xiaofeiluo.router.applaction.IAppInit


@Route(path = AppModules.module2AppInit)
class Module2Applaction : IAppInit {

    override fun initApp(applaction: Application) {
        Log.e("Module2Applaction","initApp")
    }


    override fun init(context: Context) {

    }
}
