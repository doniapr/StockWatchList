package com.stockbit.model.remote

import com.google.gson.annotations.SerializedName

data class WatchListResponse(
    @SerializedName("Message")
    val message: String,
    @SerializedName("Type")
    val type: Int,
    @SerializedName("Data")
    val data: List<DataResponse>,
)

data class DataResponse(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfoResponse,
    @SerializedName("DISPLAY")
    val display: DisplayResponse,
)

data class CoinInfoResponse(
    @SerializedName("Id")
    val id: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("FullName")
    val fullname: String,
    @SerializedName("Internal")
    val internal: String,
)

data class DisplayResponse(
    @SerializedName("IDR")
    val idr: IdrResponse,
)

data class IdrResponse(
    @SerializedName("FROMSYMBOL")
    val fromSymbol: String,
    @SerializedName("TOSYMBOL")
    val toSymbol: String,
    @SerializedName("MARKET")
    val market: String,
    @SerializedName("PRICE")
    val price: String,
    @SerializedName("CHANGE24HOUR")
    val change24Hour: String,
    @SerializedName("CHANGEPCT24HOUR")
    val changePct24Hour: String,
)