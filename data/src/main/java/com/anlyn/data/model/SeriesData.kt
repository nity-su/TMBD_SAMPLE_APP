package com.anlyn.data.model

import android.media.Rating
import com.google.gson.annotations.SerializedName

data class SeriesData(
        @SerializedName("name")
        val name:String,
        @SerializedName("poster_path")
        val url:String,
        val rating:Int =0)