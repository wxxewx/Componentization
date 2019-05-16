package com.xiaofeiluo.componentization

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.xiaofeiluo.base.IAppInit
import com.xiaofeiluo.router.AppModules

class MyApplaction : Application() {

    override fun onCreate() {
        super.onCreate()
        initRouter()
        initModules()
    }


    private fun initModules() {
        val modules = getString(R.string.modules).split(",")
        modules.forEach { module ->
            val modulePath = AppModules.getModulePath(module)
            if (modulePath != null) {
                val navigation = ARouter.getInstance().build(modulePath).navigation()
                if (navigation != null && navigation is IAppInit) {
                    navigation.initApp(this)
                }
            }
        }
    }

    private fun initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}