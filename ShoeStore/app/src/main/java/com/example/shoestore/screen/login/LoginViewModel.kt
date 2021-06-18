package com.example.shoestore.screen.login

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


private const val USER = "bmota"
private const val PASSWORD = "Test001"

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

    private val _eventErrorLogin = MutableLiveData<Boolean>()
    val eventErrorLogin : LiveData<Boolean>
        get() = _eventErrorLogin

    init {
        _eventLogin.value = false
        _eventErrorLogin.value = false
    }

    fun setUsername(value: Editable){
        _userName.value = value.toString()
    }

    fun setPassword(value: Editable){
        _password.value = value.toString()
    }

    fun onClickLogin() {

        if (_userName.value.isNullOrEmpty() || _password.value.isNullOrEmpty()){
            _eventErrorLogin.value = true
        }
       else {
            _eventErrorLogin.value = !(_userName.value == USER && _password.value == PASSWORD)
            _eventLogin.value = _userName.value == USER && _password.value == PASSWORD
        }

    }

    fun clearEventError(){
        _eventErrorLogin.value = false
        _eventLogin.value = false
    }



}