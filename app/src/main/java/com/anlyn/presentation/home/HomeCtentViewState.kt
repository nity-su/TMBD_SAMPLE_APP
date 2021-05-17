package com.anlyn.presentation.home

import com.anlyn.domain.entitiy.MovieEntity

data class HomeCtentViewState(val isLoading:Boolean,val movieList:List<MovieEntity>?= null)