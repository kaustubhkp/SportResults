package com.sport.results.app.utils

sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorText: String?
    ) : Resource<Nothing>()

    data object Loading : Resource<Nothing>()
}