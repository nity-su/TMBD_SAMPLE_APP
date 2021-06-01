package com.anlyn.domain

import com.anlyn.domain.entitiy.MovieEntity
import com.anlyn.domain.entitiy.SeriesEntity
import io.reactivex.rxjava3.core.Observable

interface MovieDataSource {
    fun getMovies(language:String,page:Int) : Observable<List<MovieEntity>>
    fun getSeries(language:String,page:Int) : Observable<List<SeriesEntity>>
}