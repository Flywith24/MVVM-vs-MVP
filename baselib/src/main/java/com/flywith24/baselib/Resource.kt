package com.flywith24.baselib

/**
 * @author yyz (杨云召)
 * @date   2020/3/20
 * time   16:23
 * description
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}