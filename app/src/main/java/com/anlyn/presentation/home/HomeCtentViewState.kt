package com.anlyn.presentation.home

import com.anlyn.domain.entitiy.MovieEntity
import com.anlyn.domain.entitiy.SeriesEntity

data class MovieViewState(val isLoading:Boolean,val movieList:List<MovieEntity>?= null)
data class SeriesViewState(val isLoading:Boolean,val list:List<SeriesEntity>?= null)