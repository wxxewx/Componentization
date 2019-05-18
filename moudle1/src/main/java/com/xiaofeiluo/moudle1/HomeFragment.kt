package com.xiaofeiluo.moudle1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.xiaofeiluo.router.module1.Module1RouterPath

import kotlinx.android.synthetic.main.home.*

@Route(path = Module1RouterPath.home_fragment)
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            ARouter.getInstance().build(Module1RouterPath.home_activity).navigation()
        }
    }
}