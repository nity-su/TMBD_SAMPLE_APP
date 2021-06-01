package com.anlyn.data.remote.api

import com.anlyn.data.model.MovieListData
import com.anlyn.data.model.SeriesListData
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TDMBApi{
    companion object {
        val BASE_URL: String
            get() = "https://api.themoviedb.org/3/"
        val api_key:String
            get() = "d63067c42f53b7d5aa1a067c2fc2ab07"
        val POSTER_BASE_URL:String
            get() = "http://image.tmdb.org/t/p"

    }

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") key:String,
                         @Query("language") language:String, @Query("page") page:Int) : Observable<MovieListData>

    @GET("tv/popular")
    fun getPopularSeries(@Query("api_key") key:String,
                         @Query("language") language:String, @Query("page") page:Int) : Observable<SeriesListData>
}

