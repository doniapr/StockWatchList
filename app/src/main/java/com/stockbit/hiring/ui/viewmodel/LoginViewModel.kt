package com.stockbit.hiring.ui.viewmodel

import com.stockbit.common.base.BaseViewModel
import com.stockbit.hiring.usecase.UserUseCase
import com.stockbit.model.domain.User

class LoginViewModel(private val userUseCase: UserUseCase): BaseViewModel() {
    fun login(name: String) {
        userUseCase.login(User(1, name))
    }
}