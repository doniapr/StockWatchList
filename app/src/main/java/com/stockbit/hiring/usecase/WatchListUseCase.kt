package com.stockbit.hiring.usecase

import com.stockbit.model.domain.WatchList
import com.stockbit.repository.WatchListRepository
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow


interface WatchListUseCase {
    fun getData(): Flow<Resource<WatchList>>
}

class WatchListUseCaseImpl(private val watchListRepository: WatchListRepository) : WatchListUseCase {
    override fun getData(): Flow<Resource<WatchList>> =
        watchListRepository.getData()
}