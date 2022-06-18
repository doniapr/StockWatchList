package com.stockbit.hiring.di

import com.stockbit.hiring.LoginViewModel
import com.stockbit.local.di.localModule
import com.stockbit.remote.di.createRemoteModule
import com.stockbit.repository.di.repositoryModule
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { LoginViewModel() }
}

val appComponent= listOf(createRemoteModule("https://api.github.com/"), repositoryModule, localModule, viewModelModule)