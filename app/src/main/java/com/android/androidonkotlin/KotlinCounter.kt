package com.android.androidonkotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class KotlinCounter(
    val name: String,
    var counter: Int

): Parcelable{
    fun increment() {
        counter++
    }

    fun decrement() {
        counter--
    }
}