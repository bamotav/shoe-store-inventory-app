package com.example.shoestore.screen.instructions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class InstructionViewModelFactory(private val screenItem: ScreenItem) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InstructionViewModel::class.java)) {
            return InstructionViewModel(screenItem) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}