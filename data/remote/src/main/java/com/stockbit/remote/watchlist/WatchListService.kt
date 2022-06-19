package com.stockbit.remote.watchlist

import com.stockbit.model.remote.WatchListResponse
import retrofit2.http.GET

interface WatchListService {
    @GET("top/totaltoptiervolfull?limit=50&tsym=IDR")
    suspend fun getData(): WatchListResponse
}