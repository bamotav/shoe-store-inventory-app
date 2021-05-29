package com.example.shoestore.screen.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.screen.instructions.ScreenItem

class WelcomeViewModel(private val screenItemData: List<ScreenItem>): ViewModel() {

    private val _screeItems = MutableLiveData<List<ScreenItem>>()

    val screenItems :LiveData<List<ScreenItem>>
    get() = _screeItems

    init {
        _screeItems.value = screenItemData
    }

}