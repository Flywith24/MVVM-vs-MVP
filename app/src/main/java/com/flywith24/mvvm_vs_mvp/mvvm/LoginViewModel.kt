package com.flywith24.mvvm_vs_mvp.mvvm

import androidx.lifecycle.*
import androidx.lifecycle.Transformations.switchMap
import com.flywith24.baselib.LoginRequest
import com.flywith24.baselib.Resource
import kotlin.math.log

/**
 * @author yyz (杨云召)
 * @date   2020/3/20
 * time   15:01
 * description
 */
class LoginViewModel(private val repository: LoginRepository) : ViewModel() {
    private val _loginRequest = MutableLiveData<LoginRequest>()
    val loginResult: LiveData<Resource<String>> = switchMap(_loginRequest) {
        repository.login(it)
    }

    fun login(loginRequest: LoginRequest) {
        _loginRequest.value = loginRequest
    }

    @Suppress("UNCHECKED_CAST")
    class LoginViewModelFactory(
        private val repository: LoginRepository
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return LoginViewModel(repository) as T
        }
    }
}