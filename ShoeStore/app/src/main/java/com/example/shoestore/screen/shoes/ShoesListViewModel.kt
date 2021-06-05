package com.example.shoestore.screen.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.screen.shoes.data.Shoe

class ShoesListViewModel(shoesData: Shoe) : ViewModel() {

    private val _shoes = MutableLiveData<Shoe>()
    val shoes: LiveData<Shoe>
        get() = _shoes

    init {
        _shoes.value = shoesData
    }
}