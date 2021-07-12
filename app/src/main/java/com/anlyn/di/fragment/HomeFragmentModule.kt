package com.anlyn.di.fragment

import androidx.lifecycle.ViewModel
import com.anlyn.data.remote.RemoteRepository
import com.anlyn.domain.Repository
import com.anlyn.domain.common.Transformer
import com.anlyn.domain.entitiy.MovieEntity
import com.anlyn.domain.usecase.GetMovieUseCase
import com.anlyn.domain.usecase.GetSeriesUseCase
import com.anlyn.presentation.common.ASyncTransformer
import com.anlyn.presentation.common.ViewModelFactory
import com.anlyn.presentation.home.HomeViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class HomeFragmentModule {

    @Provides
    fun getGetMovieUseCase(repository:RemoteRepository):GetMovieUseCase {
       return GetMovieUseCase(ASyncTransformer(),repository)
    }

    @Provides
    fun providesGetSeriesUseCase(repository: RemoteRepository):GetSeriesUseCase{
        return GetSeriesUseCase(ASyncTransformer(),repository)
    }


}