package com.flywith24.mvvm_vs_mvp.mvp

import com.flywith24.baselib.LoginRequest

/**
 * @author yyz (杨云召)
 * @date   2020/3/20
 * time   15:26
 * description
 */
interface LoginContract {

    interface Model {
        fun login(loginRequest: LoginRequest)
    }

    interface View {
        fun loginSuccess(loginInfo: String?)

        fun loginFailed(error: String)
    }

    interface Presenter {
        fun login(loginRequest: LoginRequest)
    }
}