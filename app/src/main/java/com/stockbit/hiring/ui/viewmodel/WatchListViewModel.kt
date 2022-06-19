package com.stockbit.hiring.ui.viewmodel

import android.util.Log
import com.stockbit.common.base.BaseViewModel
import com.stockbit.hiring.usecase.WatchListUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WatchListViewModel(private val watchListUseCase: WatchListUseCase): BaseViewModel() {
    fun getData() {
        GlobalScope.launch {
            watchListUseCase.getData().collect {
                Log.e("data", it.toString())
            }
        }
    }
}