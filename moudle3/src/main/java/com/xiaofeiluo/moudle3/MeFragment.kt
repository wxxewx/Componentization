package com.xiaofeiluo.moudle3

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.bus.event.UserEvent
import com.example.bus.liveBus.BusManager
import com.xiaofeiluo.router.module1.Module1RouterPath
import com.xiaofeiluo.router.module3.IUserInfoService
import com.xiaofeiluo.router.module3.Module3RouterPath
import kotlinx.android.synthetic.main.me.*


@Route(path = Module3RouterPath.me_fragment)
class MeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.me, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUernfo()

        Module1Home.setOnClickListener {
            ARouter.getInstance().build(Module1RouterPath.home_activity).navigation()
        }
        BusManager.call(UserEvent::class).observe(this) {
            name.text = it.newName
        }
    }

    private fun initUernfo() {
        val userInfo = ARouter.getInstance().build(Module3RouterPath.UserInfoService).navigation()
        userInfo?.let {
            if (it is IUserInfoService) {
                it.getUserAge {
                    age.text = it
                }
                it.getUserName {
                    name.text = it
                }
                it.getUserSchool {
                    school.text = it
                }
            }
        }
    }


}