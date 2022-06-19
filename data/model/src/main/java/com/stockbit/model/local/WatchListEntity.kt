package com.stockbit.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watchlist")
data class WatchListEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "fullname")
    val fullname: String,
    @ColumnInfo(name = "internal")
    val internal: String,
    @ColumnInfo(name = "fromSymbol")
    val fromSymbol: String,
    @ColumnInfo(name = "toSymbol")
    val toSymbol: String,
    @ColumnInfo(name = "market")
    val market: String,
    @ColumnInfo(name = "price")
    val price: String,
    @ColumnInfo(name = "change24Hour")
    val change24Hour: String,
    @ColumnInfo(name = "changePctHour")
    val changePct24Hour: String,

)
