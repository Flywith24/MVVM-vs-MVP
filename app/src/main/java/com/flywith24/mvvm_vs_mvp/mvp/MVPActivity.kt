package com.flywith24.mvvm_vs_mvp.mvp

import com.flywith24.baselib.BaseActivity
import com.flywith24.baselib.LoginRequest
import com.flywith24.mvvm_vs_mvp.R
import kotlinx.android.synthetic.main.activity_main.*

class MVPActivity : BaseActivity(R.layout.activity_main), LoginContract.View {
    private lateinit var mPresenter: LoginPresenter

    override fun init() {
        mPresenter = LoginPresenter()
        mPresenter.attachView(this)
        login.setOnClickListener {
            mPresenter.login(LoginRequest(username.text.toString(), password.text.toString()))
        }
    }

    override fun loginSuccess(loginInfo: String?) {
        //成功操作
    }

    override fun loginFailed(error: String) {
        //失败操作
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}
