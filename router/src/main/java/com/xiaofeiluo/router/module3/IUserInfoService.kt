package com.xiaofeiluo.router.module3

import com.alibaba.android.arouter.facade.template.IProvider

interface IUserInfoService : IProvider {
    fun getUserName(callback: (name: String) -> Unit)
    fun getUserAge(callback: (age: String) -> Unit)
    fun getUserSchool(callback: (school: String) -> Unit)

}