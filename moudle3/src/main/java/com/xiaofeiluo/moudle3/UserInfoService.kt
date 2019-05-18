package com.xiaofeiluo.moudle3

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaofeiluo.router.module3.IUserInfoService
import com.xiaofeiluo.router.module3.Module3RouterPath
import kotlin.concurrent.thread

@Route(path = Module3RouterPath.UserInfoService)
class UserInfoService : IUserInfoService {

    private var name: String? = null
    private var age: String? = null
    private var school: String? = null

    private var handler: Handler? = null

    override fun getUserName(callback: (name: String) -> Unit) {
        if (TextUtils.isEmpty(name)) {
            thread {
                Thread.sleep(1000);
                name = "张三"
                handler?.post {
                    callback.invoke(name!!)
                }
            }
        } else {
            callback.invoke(name!!)
        }

    }

    override fun getUserAge(callback: (age: String) -> Unit) {
        if (TextUtils.isEmpty(age)) {
            thread {
                Thread.sleep(1000);
                age = "10"
                handler?.post {
                    callback.invoke(age!!)
                }
            }
        } else {
            callback.invoke(age!!)
        }
    }

    override fun getUserSchool(callback: (school: String) -> Unit) {
        if (TextUtils.isEmpty(school)) {
            thread {
                Thread.sleep(1000);
                school = "清华大学"
                handler?.post {
                    callback.invoke(school!!)
                }
            }
        } else {
            callback.invoke(school!!)
        }
    }

    override fun init(context: Context?) {
        handler = Handler(Looper.getMainLooper())
    }
}