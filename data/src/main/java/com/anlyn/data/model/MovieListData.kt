package com.anlyn.data.model

import com.anlyn.data.MovieData
import com.google.gson.annotations.SerializedName

data class MovieListData(
    @SerializedName("results") val list:List<MovieData>
)