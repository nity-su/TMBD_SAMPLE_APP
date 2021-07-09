package com.anlyn.data

import android.util.Log
import com.anlyn.data.Mapper.DataEntityMapper
import com.anlyn.data.Mapper.SeriesDataEntityMapper
import com.anlyn.data.model.MovieListData
import com.anlyn.data.remote.api.TDMBApi
import com.anlyn.domain.MovieDataSource
import com.anlyn.domain.entitiy.MovieEntity
import com.anlyn.domain.entitiy.SeriesEntity
import io.reactivex.rxjava3.core.Observable

class RemoteDataSource(private val tdmpApi:TDMBApi,private val mapper: DataEntityMapper,
                       private val seriesMapper: SeriesDataEntityMapper) : MovieDataSource {
    private val TDMB_API_KEY = TDMBApi.api_key

    override fun getMovies(language:String,page:Int): Observable<List<MovieEntity>> {
        return tdmpApi.getPopularMovies(TDMB_API_KEY,language,page)
            .flatMap { data ->
                Log.d(this::class.simpleName, System.currentTimeMillis().toString())
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

    override fun getSeries(language: String, page: Int): Observable<List<SeriesEntity>> {
        return tdmpApi.getPopularSeries(TDMB_API_KEY,language,page)
                .flatMap { data->
                    val list = ArrayList<SeriesEntity>()
                    data.list.forEach {
                        list.add(seriesMapper.mapFrom(it))
                    }
                    Observable.create<List<SeriesEntity>> {
                        it.onNext(list)
                        it.onComplete()
                    }
                }
    }
}