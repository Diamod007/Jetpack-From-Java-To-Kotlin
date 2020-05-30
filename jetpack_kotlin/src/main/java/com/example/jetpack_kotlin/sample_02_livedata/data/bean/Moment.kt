package com.example.jetpack_kotlin.sample_02_livedata.data.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   20:02
 * description
 */
@Parcelize
data class Moment(
        val content: String,
        val location: String,
        val imgUrl: String,
        val username: String,
        val userAvatar: String
) : Parcelable