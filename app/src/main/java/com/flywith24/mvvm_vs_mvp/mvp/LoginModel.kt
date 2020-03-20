package com.flywith24.mvvm_vs_mvp.mvp

import com.flywith24.baselib.LoginRequest

/**
 * @author yyz (杨云召)
 * @date   2020/3/20
 * time   15:18
 * description
 */
class LoginModel : LoginContract.Model {
    override fun login(loginRequest: LoginRequest) {
        //login操作
        //网络请求
    }
}