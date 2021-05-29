package com.example.shoestore.screen.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoestore.screen.instructions.InstructionViewModel
import com.example.shoestore.screen.instructions.ScreenItem


class WelcomeViewModelFactory(private val screenItemData: List<ScreenItem>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomeViewModel::class.java)) {
            return WelcomeViewModel(screenItemData) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}