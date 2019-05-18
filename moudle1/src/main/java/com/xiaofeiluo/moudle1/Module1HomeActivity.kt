package com.xiaofeiluo.moudle1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.xiaofeiluo.router.module1.Module1RouterPath
import com.xiaofeiluo.router.module3.IUserInfoService
import com.xiaofeiluo.router.module3.Module3RouterPath
import kotlinx.android.synthetic.main.activity_module1_home.*


@Route(path = Module1RouterPath.home_activity)
class Module1HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module1_home)
        getName.setOnClickListener {
            val userInfo = ARouter.getInstance().build(Module3RouterPath.UserInfoService).navigation()
            userInfo?.let {
                if (it is IUserInfoService) {
                    it.getUserName {
                        name.text = it
                    }
                }
            }
        }
    }
}
