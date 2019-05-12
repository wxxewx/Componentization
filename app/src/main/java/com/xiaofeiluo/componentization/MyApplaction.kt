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
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()  // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)
    }
}