package com.example.tvchannelremote.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tvchannelremote.data.TVChannel

class HomeRepository {

    private val tvChannels = mutableListOf(
        TVChannel("CBS", 4),
        TVChannel("ABC", 5),
        TVChannel("FOX", 9),
        TVChannel("NBC", 11),
        TVChannel("CC", 15),
        TVChannel("TBS", 14),
        TVChannel("ESPN", 13),
        TVChannel("ESPN2", 16),
        TVChannel("ESPN3", 18),
        TVChannel("ESPN4", 19),
        TVChannel("ESPN5", 12),
        TVChannel("TNT", 17)
    )

    fun getTVChannels(): MutableLiveData<List<TVChannel>> {
        val results = MutableLiveData<List<TVChannel>>()
        results.value = tvChannels
        return results
    }

    fun addTVChannel(tvChannel: TVChannel) {
        tvChannels.add(tvChannel)
    }
}