package com.anlyn.presentation.movie

import com.anlyn.domain.entitiy.MovieEntity

data class MovieViewState(var isLoading:Boolean,var movieList:List<MovieEntity>?= null)