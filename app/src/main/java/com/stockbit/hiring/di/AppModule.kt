package com.stockbit.hiring.di

import com.stockbit.hiring.ui.viewmodel.LoginViewModel
import com.stockbit.hiring.usecase.UserUseCase
import com.stockbit.hiring.usecase.UserUseCaseImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<UserUseCase> { UserUseCaseImpl(get()) }
}

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
}