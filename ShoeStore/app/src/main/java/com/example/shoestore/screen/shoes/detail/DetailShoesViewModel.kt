package com.example.shoestore.screen.shoes.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.screen.shoes.data.Shoe

class DetailShoesViewModel (private val shoe: Shoe)  : ViewModel() {

    private val _model =  MutableLiveData<String>()
    val model : LiveData<String>
        get() = _model

    private val _name = MutableLiveData<String>()
    val name : LiveData<String>
        get() = _name

    private val _description = MutableLiveData<String>()
    val description : LiveData<String>
    get() = _description

    private val _price = MutableLiveData<Double>()
    val price: LiveData<Double>
    get() = _price

    private val _image = MutableLiveData<Int>()
    val image: LiveData<Int>
    get() = _image

    init {

        _model.value = shoe.model
        _name.value = shoe.name
        _description.value = shoe.description
        _price.value = shoe.price
        _image.value = shoe.shoeImg
    }




}