package com.xiaofeiluo.componentization

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.xiaofeiluo.router.module1Home
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        module1.setOnClickListener {
            ARouter.getInstance().build(module1Home).navigation();
        }
    }
}
