package com.stockbit.repository

import com.stockbit.local.dao.WatchListDao
import com.stockbit.model.domain.WatchList
import com.stockbit.model.remote.WatchListResponse
import com.stockbit.model.utils.WatchListDataMapper
import com.stockbit.remote.ApiResponse
import com.stockbit.remote.watchlist.WatchListDatasource
import com.stockbit.repository.utils.NetworkBoundResource
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface WatchListRepository {
    fun getData(): Flow<Resource<WatchList>>
}

class WatchListRepositoryImpl(
    private val watchListDatasource: WatchListDatasource,
    private val watchListDao: WatchListDao
) : WatchListRepository {
    override fun getData(): Flow<Resource<WatchList>> =
        object : NetworkBoundResource<WatchList, WatchListResponse>() {
            override fun loadFromDB(): Flow<WatchList> {
                return watchListDao.getAllData().map { WatchListDataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: WatchList?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<WatchListResponse>> =
                watchListDatasource.getData()

            override suspend fun saveCallResult(data: WatchListResponse) {
                val entity = WatchListDataMapper.mapResponseEntities(data)
                watchListDao.save(entity)
            }

        }.asFlow()
}