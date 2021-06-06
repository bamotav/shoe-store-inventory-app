package com.example.shoestore.screen.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.screen.instructions.ScreenItem

class WelcomeViewModel(private val screenItemData: List<ScreenItem>): ViewModel() {

    private val _screeItems = MutableLiveData<List<ScreenItem>>()

    val screenItems :LiveData<List<ScreenItem>>
    get() = _screeItems

    private val _nextEvent = MutableLiveData<Boolean>()

    val nextEvent: LiveData<Boolean>
    get() = _nextEvent

    private val _getStartedEvent = MutableLiveData<Boolean>()

    val getStartedEvent: LiveData<Boolean>
        get() = _getStartedEvent


    init {
        _screeItems.value = screenItemData
        _nextEvent.value = false
        _getStartedEvent.value = false
    }

    fun onClickNext() {

        _nextEvent.value = true
    }

    fun onClickGetStarted(){
        _getStartedEvent.value = true
    }


}