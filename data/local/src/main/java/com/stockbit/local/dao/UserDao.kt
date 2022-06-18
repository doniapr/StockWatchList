package com.stockbit.local.dao

import androidx.room.Dao
import com.stockbit.model.local.UserEntity

@Dao
abstract class UserDao: BaseDao<UserEntity>() {
    suspend fun save(data: UserEntity) {
        insert(data)
    }
}