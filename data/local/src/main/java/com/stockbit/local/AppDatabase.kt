package com.stockbit.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.stockbit.local.converter.Converters
import com.stockbit.local.dao.UserDao
import com.stockbit.local.dao.WatchListDao
import com.stockbit.model.local.UserEntity
import com.stockbit.model.local.WatchListEntity

@Database(entities = [UserEntity::class, WatchListEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    // DAO
    abstract fun userDao(): UserDao
    abstract fun watchlistDao(): WatchListDao

    companion object {

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "App.db")
                .build()
    }
}