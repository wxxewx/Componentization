package com.xiaofeiluo.base

import android.app.Application
import com.alibaba.android.arouter.facade.template.IProvider

interface IAppInit : IProvider {
    fun initApp(applaction: Application)
}