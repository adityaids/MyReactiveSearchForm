package com.aditya.myreactivesearchform.ui.main

import androidx.lifecycle.asLiveData
import com.aditya.myreactivesearchform.data.remote.network.ApiConfig
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel {
    private val accessToken = "pk.eyJ1IjoiYWRpdHlhaWRzIiwiYSI6ImNrcjl1NWZxNTRjdzAydnRmNWo0dGlwcDcifQ.-l-B63ADKlKsVmTv_kSjlg"
    val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)

    val searchResult = queryChannel.asFlow()
        .debounce(300)
        .distinctUntilChanged()
        .filter {
            it.trim().isNotEmpty()
        }
        .mapLatest {
            ApiConfig.provideApiService().getCountry(it, accessToken).features
        }
        .asLiveData()
}