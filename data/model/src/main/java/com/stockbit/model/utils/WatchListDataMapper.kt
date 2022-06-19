package com.stockbit.model.utils

import com.stockbit.model.domain.CoinInfo
import com.stockbit.model.domain.Data
import com.stockbit.model.domain.Display
import com.stockbit.model.domain.Idr
import com.stockbit.model.domain.WatchList
import com.stockbit.model.local.WatchListEntity
import com.stockbit.model.remote.WatchListResponse

object WatchListDataMapper {
    fun mapEntitiesToDomain(input: List<WatchListEntity>): WatchList {
        val result: WatchList
        val data = ArrayList<Data>()

        input.forEach { wl->
            val idr = Idr(
                wl.fromSymbol,
                wl.toSymbol,
                wl.market,
                wl.price,
                wl.change24Hour,
                wl.changePct24Hour
            )
            val coinInfo = CoinInfo(
                wl.id,
                wl.name,
                wl.fullname,
                wl.internal
            )
            data.add(Data(coinInfo, Display(idr)))
        }
        result = WatchList("Success", 100, data)

        return result
    }

    fun mapResponseEntities(input: WatchListResponse): List<WatchListEntity> {
        val result = ArrayList<WatchListEntity>()

        input.data.forEach { wl->
            val data = WatchListEntity(
                id = wl.coinInfo.id,
                name = wl.coinInfo.name,
                fullname = wl.coinInfo.fullname,
                internal = wl.coinInfo.internal,
                fromSymbol = wl.display.idr.fromSymbol,
                toSymbol = wl.display.idr.toSymbol,
                market = wl.display.idr.market,
                price = wl.display.idr.price,
                change24Hour = wl.display.idr.change24Hour,
                changePct24Hour = wl.display.idr.changePct24Hour
            )

            result.add(data)
        }

        return result
    }
}