package com.anlyn.data.remote

import com.anlyn.data.RemoteDataSource
import com.anlyn.domain.MovieDataSource
import com.anlyn.domain.Repository
import com.anlyn.domain.entitiy.MovieEntity
import com.anlyn.domain.entitiy.SeriesEntity
import io.reactivex.rxjava3.core.Observable

class RemoteRepository(val dataSource: RemoteDataSource) : Repository(){
    override fun getMovies(language:String,page:Int): Observable<List<MovieEntity>> {
       return dataSource.getMovies(language,page)
    }

    override fun getSeries(language: String, page: Int): Observable<List<SeriesEntity>> {
        return dataSource.getSeries(language,page)
    }
}