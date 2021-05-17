package com.anlyn.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anlyn.domain.usecase.GetMovieUseCase

class HomeViewModel(private val getMovieUseCase: GetMovieUseCase) : ViewModel() {

      private var _stateLiveData=MutableLiveData<HomeCtentViewState>()
      var stateLiveData:LiveData<HomeCtentViewState> = _stateLiveData
           init {
               _stateLiveData.value = HomeCtentViewState(isLoading = true)
               getMovie()
           }

        fun getMovie(){
            getMovieUseCase.execute("ko",1).subscribe({
                _stateLiveData.value = stateLiveData.value!!.copy(false,it)
                Log.d(this::class.simpleName,"success")
            },{ Log.d(this::class.simpleName,it.message.toString())})
        }

}