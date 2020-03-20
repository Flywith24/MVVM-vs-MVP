package com.flywith24.mvvm_vs_mvp.mvvm

import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import com.flywith24.baselib.BaseActivity
import com.flywith24.baselib.LoginRequest
import com.flywith24.baselib.Resource
import com.flywith24.mvvm_vs_mvp.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author yyz(杨云召)
 * @date   2020/3/20
 * time   16:33
 * description
 */
class MVVMActivity : BaseActivity(R.layout.activity_main) {
    private val mViewModel by viewModels<LoginViewModel> {
        LoginViewModel.LoginViewModelFactory(
            LoginRepository.getInstance()
        )
    }

    override fun init() {
        login.setOnClickListener {
            mViewModel.login(LoginRequest(username.text.toString(), password.text.toString()))
        }
        handleData(mViewModel.loginResult, success = {
            //成功回调
        })
    }

    private fun <T> handleData(
        liveData: LiveData<Resource<T>>, success: (T?) -> Unit = {},
        error: (String?) -> Unit = {}
    ) {
        liveData.observe(this) { result ->
            when (result) {
                is Resource.Loading -> {
                    //show loading
                }
                is Resource.Success -> {
                    //hide loading
                    success(result.data)
                }

                is Resource.Error -> {
                    //hide loading
                    error("error")
                }
            }
        }
    }
}
