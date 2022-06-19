package com.stockbit.model.domain

data class WatchList(
    val message: String,
    val type: Int,
    val data: List<Data>?,
)

data class Data(
    val coinInfo: CoinInfo,
    val display: Display,
)

data class CoinInfo(
    val id: String,
    val name: String,
    val fullname: String,
    val internal: String,
)

data class Display(
    val idr: Idr,
)

data class Idr(
    val fromSymbol: String,
    val toSymbol: String,
    val market: String,
    val price: String,
    val change24Hour: String,
    val changePct24Hour: String,
)
