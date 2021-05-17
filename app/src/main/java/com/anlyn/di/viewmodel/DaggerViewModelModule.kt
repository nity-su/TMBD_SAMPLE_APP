package com.anlyn.di.viewmodel

import androidx.lifecycle.ViewModel
import com.anlyn.domain.usecase.GetMovieUseCase
import com.anlyn.presentation.common.ViewModelFactory
import com.anlyn.presentation.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module
class DaggerViewModelModule{
    @Provides
    fun provideViewModelFactory(providerMap: Map<Class<out ViewModel>, Provider<ViewModel>>):ViewModelFactory{
        return ViewModelFactory(providerMap)
    }

    @Provides
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun provideHomeViewModel(getMovieUseCase: GetMovieUseCase):HomeViewModel{
        return HomeViewModel(getMovieUseCase)
    }
}