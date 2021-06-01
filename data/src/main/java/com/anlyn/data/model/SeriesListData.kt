package com.anlyn.data.model

import com.anlyn.data.MovieData
import com.anlyn.domain.entitiy.SeriesEntity
import com.google.gson.annotations.SerializedName

data class SeriesListData( @SerializedName("results") val list:List<SeriesData>)