package com.anlyn.data

import com.anlyn.data.Mapper.DataEntityMapper
import com.anlyn.data.remote.api.TDMBApi
import com.anlyn.domain.MovieDataSource
import com.anlyn.domain.entitiy.MovieEntity
import io.reactivex.rxjava3.core.Observable

class RemoteDataSource(private val tdmpApi:TDMBApi,private val mapper: DataEntityMapper) : MovieDataSource {
    private val API_KEY = TDMBApi.api_key
    override fun getMovies(language:String,page:Int): Observable<List<MovieEntity>> {
        return tdmpApi.getPopularMovies(API_KEY,language,page)
            .flatMap { data ->
                val list = ArrayList<MovieEntity>()
                data.list.forEach {
                    list.add(mapper.mapFrom(it))
                }
               Observable.create<List<MovieEntity>> {
                   it.onNext(list)
                   it.onComplete()
               }
            }
    }

}