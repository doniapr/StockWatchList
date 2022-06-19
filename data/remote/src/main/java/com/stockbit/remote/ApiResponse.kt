package com.stockbit.remote

import java.lang.Exception

sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val errorMessage: Exception) : ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()
}