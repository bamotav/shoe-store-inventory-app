package com.example.shoestore.screen.shoes.data

import android.content.res.Resources
import com.example.shoestore.R

fun shoeList(resources: Resources): List<Shoe> {
    return listOf(
        Shoe(1,
            resources.getString(R.string.shoe1_model),
            resources.getString(R.string.shoe1_name),
            resources.getString(R.string.shoe1_description),
            R.drawable.shoe1,
            resources.getString(R.string.shoe1_price).toDouble()
        ),

        Shoe(2,
            resources.getString(R.string.shoe1_model),
            resources.getString(R.string.shoe1_name),
            resources.getString(R.string.shoe1_description),
            R.drawable.shoe1,
            resources.getString(R.string.shoe1_price).toDouble()
        ),
        Shoe(3,
            resources.getString(R.string.shoe1_model),
            resources.getString(R.string.shoe1_name),
            resources.getString(R.string.shoe1_description),
            R.drawable.shoe1,
            resources.getString(R.string.shoe1_price).toDouble()
        )
    ,     Shoe(4,
            resources.getString(R.string.shoe1_model),
            resources.getString(R.string.shoe1_name),
            resources.getString(R.string.shoe1_description),
            R.drawable.shoe1,
            resources.getString(R.string.shoe1_price).toDouble()
        )
    )
}