package com.flywith24.mvvm_vs_mvp.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.flywith24.baselib.LoginRequest
import com.flywith24.baselib.Resource

/**
 * @author yyz (杨云召)
 * @date   2020/3/20
 * time   16:07
 * description
 */
class LoginRepository {

    fun login(loginRequest: LoginRequest): LiveData<Resource<String>> {
        //login 操作
        //网络请求或数据库请求
        return MutableLiveData()
    }

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: LoginRepository? = null

        fun getInstance() = instance
            ?: synchronized(this) {
                instance
                    ?: LoginRepository().also { instance = it }
            }
    }
}