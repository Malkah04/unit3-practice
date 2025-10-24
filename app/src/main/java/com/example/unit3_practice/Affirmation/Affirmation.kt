package com.example.unit3_practice.Affirmation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val StringRecourse :Int,
    val cnt :Int,
    @DrawableRes val imageRecourse :Int ,

)
