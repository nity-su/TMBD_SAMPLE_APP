package com.anlyn.data

import android.util.Log
import com.anlyn.data.remote.api.TDMBApi
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

public class RetrofitTest {
    fun retrofitTest(){
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val api = retrofit.create(TDMBApi::class.java)
        api.getPopularMovies("d63067c42f53b7d5aa1a067c2fc2ab07","ko",1)
            .observeOn(Schedulers.newThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d("size:",it.list.size.toString())
            },{
                Log.d("error:",it.message)
            })

    }
}