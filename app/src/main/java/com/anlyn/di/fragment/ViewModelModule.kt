package com.anlyn.di.fragment

import androidx.lifecycle.ViewModel
import com.anlyn.domain.usecase.GetMovieUseCase
import com.anlyn.presentation.common.ViewModelFactory
import com.anlyn.presentation.home.HomeViewModel
import dagger.MapKey
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
class ViewModelModule {

    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Provides
    fun provideViewModelFactory(providerMap: Map<Class<out ViewModel>, Provider<ViewModel>>): ViewModelFactory {
        return ViewModelFactory(providerMap)
    }

}