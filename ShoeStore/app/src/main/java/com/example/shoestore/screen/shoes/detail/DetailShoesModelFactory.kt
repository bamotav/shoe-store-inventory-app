package com.example.shoestore.screen.shoes.detail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoestore.screen.instructions.ScreenItem
import com.example.shoestore.screen.shoes.ShoesListViewModel
import com.example.shoestore.screen.shoes.data.DataSource
import com.example.shoestore.screen.shoes.data.Shoe
import com.example.shoestore.screen.welcome.WelcomeViewModel

class DetailShoesModelFactory(private val shoe: Shoe) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailShoesViewModel::class.java)) {
            return DetailShoesViewModel(shoe) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

