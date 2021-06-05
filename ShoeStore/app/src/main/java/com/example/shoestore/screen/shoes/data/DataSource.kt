package com.example.shoestore.screen.shoes.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource(resources: Resources) {

    private val initialShoeList = shoeList(resources)
    private val shoesLiveData = MutableLiveData(initialShoeList)

    fun getShoeList(): LiveData<List<Shoe>> {
        return shoesLiveData
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }

}