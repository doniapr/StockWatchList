package com.stockbit.remote.watchlist

import android.util.Log
import com.stockbit.model.remote.WatchListResponse
import com.stockbit.remote.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher

class WatchListDatasource(private val watchListService: WatchListService) {
    suspend fun getData(): Flow<ApiResponse<WatchListResponse>> {
        return flow {
            try {
                val response = watchListService.getData()
                Log.e("DSSuccess", response.toString())
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                Log.e("DSSuccess", e.toString())
                emit(ApiResponse.Error(e))
            }
        }.flowOn(Dispatchers.IO)
    }
}