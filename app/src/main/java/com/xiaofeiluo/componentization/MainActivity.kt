package com.xiaofeiluo.componentization

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.xiaofeiluo.router.module1Home
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tab.setOnCheckedChangeListener { radioGroup: RadioGroup, i: Int ->
            when (i) {
                home.id -> Toast.makeText(this, "1", Toast.LENGTH_LONG).show()
                wantToBuy.id -> Toast.makeText(this, "2", Toast.LENGTH_LONG).show()
                me.id -> Toast.makeText(this, "3", Toast.LENGTH_LONG).show()
            }
        }
    }
}
