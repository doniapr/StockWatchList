package com.stockbit.repository.di

import com.stockbit.repository.AppDispatchers
import com.stockbit.repository.UserRepository
import com.stockbit.repository.UserRepositoryImpl
import com.stockbit.repository.WatchListRepository
import com.stockbit.repository.WatchListRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { UserRepositoryImpl(get()) as UserRepository }
    factory { WatchListRepositoryImpl(get(), get()) as WatchListRepository }
}