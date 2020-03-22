package com.example.tvchannelremote.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tvchannelremote.data.TVChannel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun setText(string: String){
        _text.value = string
    }

    private val homeRepository: HomeRepository = HomeRepository()

    private var _tvchannels : MutableLiveData<List<TVChannel>> = homeRepository.getTVChannels()

    val tvchannels : LiveData<List<TVChannel>> = _tvchannels

    fun getTVChannels(): LiveData<List<TVChannel>> {
        return tvchannels
    }



    fun addTVChannel(tvChannel: TVChannel){
        homeRepository.addTVChannel(tvChannel)
        _tvchannels.value = homeRepository.getTVChannels().value
    }
}