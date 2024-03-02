package com.fajri.bangkit_2024_bmaaup.RecyclerView

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val photo: Int
): Parcelable
