package com.stockbit.remote.di

import com.stockbit.model.remote.WatchListResponse
import com.stockbit.remote.ExampleDatasource
import com.stockbit.remote.ExampleService
import com.stockbit.remote.watchlist.WatchListDatasource
import com.stockbit.remote.watchlist.WatchListService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRemoteModule(baseUrl: String) = module {

    factory<Interceptor> {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    factory { OkHttpClient.Builder().addInterceptor(get()).build() }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory{ get<Retrofit>().create(ExampleService::class.java) }
    factory{ get<Retrofit>().create(WatchListService::class.java) }

    factory { ExampleDatasource(get()) }
    factory { WatchListDatasource(get()) }
}