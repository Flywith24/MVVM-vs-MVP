package com.flywith24.mvvm_vs_mvp.mvp

import com.flywith24.baselib.LoginRequest


/**
 * @author yyz (杨云召)
 * @date   2020/3/20
 * time   15:07
 * description
 */
class LoginPresenter : LoginContract.Presenter {
    private val mModel: LoginContract.Model = LoginModel()
    private var mView: LoginContract.View? = null

    fun attachView(view: LoginContract.View) {
        mView = view
    }

    fun detachView() {
        mView = null
    }

    fun isViewAttached(): Boolean = mView != null

    override fun login(loginRequest: LoginRequest) {
        mModel.login(loginRequest)
    }
}