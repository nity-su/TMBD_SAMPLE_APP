package com.anlyn.data
import com.google.gson.annotations.SerializedName
data class MovieData(
    @SerializedName("title") val title:String,
    @SerializedName("poster_path") val poster_path:String,
    @SerializedName("vote_average") val vote_average:String)