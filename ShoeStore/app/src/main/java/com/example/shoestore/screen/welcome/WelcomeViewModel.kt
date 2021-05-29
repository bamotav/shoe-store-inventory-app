package com.example.shoestore.screen.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.screen.instructions.ScreenItem

class WelcomeViewModel(): ViewModel() {


    private val _screeItems = MutableLiveData<List<ScreenItem>>()

    val screenItems :LiveData<List<ScreenItem>>
    get() = _screeItems


    init {

        _screeItems.value = listOf<ScreenItem>(
            ScreenItem("Test 1", "Test Description", 32),
            ScreenItem("Test 2", "Test Description", 32),
            ScreenItem("Test 3", "Test Description", 32),
            ScreenItem("Test 4", "Test Description", 32),
            ScreenItem("Test 5", "Test Description", 32)
        )

    }

}