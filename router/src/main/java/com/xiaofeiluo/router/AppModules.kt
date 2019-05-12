package com.xiaofeiluo.router


const val module1AppInit = "/module1/appInit"
const val module2AppInit = "/module2/appInit"
const val module3AppInit = "/module3/appInit"

object AppModules {

    fun getModulePath(module: String): String? {
        return when (module) {
            "moudle1" -> module1AppInit
            "moudle2" -> module2AppInit
            "moudle3" -> module3AppInit

            else -> null
        }
    }


}
