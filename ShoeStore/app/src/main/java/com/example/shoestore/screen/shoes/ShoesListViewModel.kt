package com.example.shoestore.screen.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.screen.shoes.data.DataSource
import com.example.shoestore.screen.shoes.data.Shoe

class ShoesListViewModel(private val dataSource: DataSource) : ViewModel() {
    val shoesLiveData = dataSource.getShoeList()
}
