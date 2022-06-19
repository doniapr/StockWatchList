package com.stockbit.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.stockbit.model.local.WatchListEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WatchListDao: BaseDao<WatchListEntity>() {
    @Query("SELECT * FROM watchlist")
    abstract fun getAllData(): Flow<List<WatchListEntity>>

    suspend fun save(data: List<WatchListEntity>) {
        insert(data)
    }
}