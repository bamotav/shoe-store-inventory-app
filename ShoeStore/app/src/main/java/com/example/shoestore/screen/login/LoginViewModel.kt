package com.example.shoestore.screen.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _userName =  MutableLiveData<String>()
    val userName : LiveData<String>
        get() = _userName


    fun onSetName(){
        _userName.value = "Brayan Mota"
        _userName.postValue("brayan mota")
    }

}