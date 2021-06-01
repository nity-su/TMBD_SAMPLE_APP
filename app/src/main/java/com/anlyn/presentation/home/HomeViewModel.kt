package com.anlyn.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anlyn.domain.usecase.GetMovieUseCase
import com.anlyn.domain.usecase.GetSeriesUseCase

class HomeViewModel(private val getMovieUseCase: GetMovieUseCase,private val getSeriesUseCase: GetSeriesUseCase) : ViewModel() {

      private var _movieState=MutableLiveData<MovieViewState>()
      var movieState:LiveData<MovieViewState> = _movieState

    private var _seriesState=MutableLiveData<SeriesViewState>()
    var seriesState:LiveData<SeriesViewState> = _seriesState
           init {
               _movieState.value = MovieViewState(isLoading = true)
               _seriesState.value = SeriesViewState(isLoading = true)
               getMovie()
               getSeries()
           }

        fun getMovie(){
            getMovieUseCase.execute("ko",1).subscribe({
                //예외처리
                _movieState.value = movieState.value!!.copy(false,it)
                Log.d(this::class.simpleName,"success")
            },{ Log.d(this::class.simpleName,it.message.toString())})
        }
        fun getSeries(){
            getSeriesUseCase.execute("ko",1).subscribe({
                _seriesState.value = seriesState.value!!.copy(isLoading = false,it)
                Log.d(this::class.simpleName,"success")
            },{
                Log.d(this::class.simpleName,it.message.toString())
            })
        }

}