package com.xiaofeiluo.moudle1

import android.app.Application
import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaofeiluo.router.applaction.AppModules
import com.xiaofeiluo.router.applaction.IAppInit


@Route(path = AppModules.module1AppInit)
class Module1Applaction : IAppInit {

    override fun initApp(applaction: Application) {
        Log.e("Module1Applaction","initApp")
    }


    override fun init(context: Context) {

    }
}
