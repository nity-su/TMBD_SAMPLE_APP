package com.anlyn.domain

import com.anlyn.domain.entitiy.MovieEntity
import io.reactivex.rxjava3.core.Observable

abstract class Repository{
   abstract fun getMovies(language:String,page:Int):Observable<List<MovieEntity>>
}