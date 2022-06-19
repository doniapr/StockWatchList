package com.stockbit.hiring.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.stockbit.common.base.BaseViewModel
import com.stockbit.hiring.usecase.WatchListUseCase
import com.stockbit.model.domain.WatchList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WatchListViewModel(private val watchListUseCase: WatchListUseCase): BaseViewModel() {
    private val _watchList = MutableLiveData<WatchList>()

    val watchList: LiveData<WatchList>
        get() = _watchList

    fun getData() {
        GlobalScope.launch {
            watchListUseCase.getData().collect {
                _watchList.postValue(it.data)
            }
        }
    }
}