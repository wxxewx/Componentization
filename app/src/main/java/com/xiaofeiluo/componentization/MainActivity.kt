package com.xiaofeiluo.componentization

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import com.xiaofeiluo.router.RouterUtil
import com.xiaofeiluo.router.home_fragment
import com.xiaofeiluo.router.me_fragment
import com.xiaofeiluo.router.wanttobuy_fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tab.setOnCheckedChangeListener { radioGroup: RadioGroup, i: Int ->
            when (i) {
                home.id -> checkedHome()
                wantToBuy.id -> checkedWantToBuy()
                me.id -> checkedMe()
            }
        }
        tab.check(home.id)
    }

    private fun checkedWantToBuy() {
        val beginTransaction = supportFragmentManager.beginTransaction()
        RouterUtil.getFragment(wanttobuy_fragment)?.let { beginTransaction.replace(R.id.content, it).commit() }
    }

    private fun checkedMe() {
        val beginTransaction = supportFragmentManager.beginTransaction()
        RouterUtil.getFragment(me_fragment)?.let { beginTransaction.replace(R.id.content, it).commit() }
    }

    private fun checkedHome() {
        val beginTransaction = supportFragmentManager.beginTransaction()
        val fragment = RouterUtil.getFragment(home_fragment)
        fragment?.let {
            beginTransaction.replace(R.id.content,it).commit()
        }

    }


}
