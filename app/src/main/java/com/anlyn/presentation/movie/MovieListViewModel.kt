package com.anlyn.presentation.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anlyn.domain.entitiy.MovieEntity
import com.anlyn.domain.usecase.GetMovieUseCase
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val getMovieUseCase: GetMovieUseCase) : ViewModel() {
    private val TAG = MovieListViewModel::class.simpleName
    private var _liveData = MutableLiveData<MovieViewState>()
    val liveDataState : LiveData<MovieViewState> = _liveData
    init {
        _liveData.value = MovieViewState(isLoading = true)
    }

    fun getMovies(page:Int){
        getMovieUseCase.execute("ko",page).subscribe(
                {
                    Log.d(this::class.simpleName, System.currentTimeMillis().toString())
                    Log.d(this::class.simpleName, Thread.currentThread().name)
                    _liveData.value = _liveData.value!!.copy(false,it)
                },{
                    Log.d(TAG,it.message)
        }
        )
    }
}