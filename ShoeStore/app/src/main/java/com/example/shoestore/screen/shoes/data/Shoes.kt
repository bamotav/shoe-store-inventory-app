package com.example.shoestore.screen.shoes.data

import android.content.res.Resources
import com.example.shoestore.R

fun shoeList(resources: Resources): List<Shoe> {
    return listOf(
        Shoe(1,
            resources.getString(R.string.shoe1_model),
            resources.getString(R.string.shoe1_name),
            resources.getString(R.string.shoe1_description),
            R.drawable.ic_running_shoe,
            resources.getString(R.string.shoe1_price).toDouble(),
            "#FF6167"
        ),

        Shoe(2,
            resources.getString(R.string.shoe2_model),
            resources.getString(R.string.shoe2_name),
            resources.getString(R.string.shoe2_description),
            R.drawable.ic_running_shoe,
            resources.getString(R.string.shoe2_price).toDouble(),
            "#FF6167"
        ),
        Shoe(3,
            resources.getString(R.string.shoe3_model),
            resources.getString(R.string.shoe3_name),
            resources.getString(R.string.shoe3_description),
            R.drawable.ic_sneakers,
            resources.getString(R.string.shoe3_price).toDouble(),
            "#FF4D9ADC"
        )
    ,     Shoe(4,
            resources.getString(R.string.shoe1_model),
            resources.getString(R.string.shoe1_name),
            resources.getString(R.string.shoe1_description),
            R.drawable.ic_sneakers,
            resources.getString(R.string.shoe1_price).toDouble(),
            "#FF4D9ADC"

        )
    )
}