package com.ifs21040.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dino(
    var icon: Int,
    var name: String,
    var description: String,
    var characteristic: String,
    var habit: String,
    var food: String,
    var longheight: String,
    var weakness: String,
) : Parcelable
