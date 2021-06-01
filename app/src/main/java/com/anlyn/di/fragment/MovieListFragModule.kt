package com.anlyn.di.fragment

import com.anlyn.data.remote.RemoteRepository
import com.anlyn.domain.usecase.GetMovieUseCase
import com.anlyn.presentation.common.ASyncTransformer
import dagger.Module
import dagger.Provides

@Module
class MovieListFragModule() {
    @Provides
    fun getGetMovieUseCase(repository: RemoteRepository): GetMovieUseCase {
        return GetMovieUseCase(ASyncTransformer(),repository)
    }
}