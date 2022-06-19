package com.stockbit.hiring.di

import com.stockbit.hiring.ui.viewmodel.LoginViewModel
import com.stockbit.hiring.ui.viewmodel.WatchListViewModel
import com.stockbit.hiring.usecase.UserUseCase
import com.stockbit.hiring.usecase.UserUseCaseImpl
import com.stockbit.hiring.usecase.WatchListUseCase
import com.stockbit.hiring.usecase.WatchListUseCaseImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<UserUseCase> { UserUseCaseImpl(get()) }
    factory<WatchListUseCase> { WatchListUseCaseImpl(get()) }
}

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { WatchListViewModel(get()) }
}