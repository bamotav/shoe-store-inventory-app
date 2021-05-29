package com.example.shoestore.screen.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewModel(private val screenItemData: ScreenItem) : ViewModel(){

    private val _screenItem = MutableLiveData<ScreenItem>()
    val screenItem: LiveData<ScreenItem>
        get() = _screenItem

    init {
        _screenItem.value = screenItemData
    }




}