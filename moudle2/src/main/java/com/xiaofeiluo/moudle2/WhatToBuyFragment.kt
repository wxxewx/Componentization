package com.xiaofeiluo.moudle2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiaofeiluo.router.wanttobuy_fragment

@Route(path = wanttobuy_fragment)
class WhatToBuyFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.wanttobuy,null)
    }
}