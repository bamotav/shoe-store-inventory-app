package com.example.shoestore.screen.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {


    private val _userName =  MutableLiveData<String>()
    val userName : LiveData<String>
        get() = _userName

    private val _password = MutableLiveData<String>()
    val password : LiveData<String>
        get() = _password

    private val _eventLogin = MutableLiveData<Boolean>()
    val eventlogin : LiveData<Boolean>
        get() = _eventLogin

    init {
        _eventLogin.value = false
    }


    fun onClickLogin() {

        _eventLogin.value = true
    }



}