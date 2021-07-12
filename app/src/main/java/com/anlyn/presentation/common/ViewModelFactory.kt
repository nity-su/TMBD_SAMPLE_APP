package com.anlyn.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

class ViewModelFactory @Inject constructor(val providerMap: Map<Class<out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val getClass= providerMap.get(modelClass) ?: providerMap.asIterable()
            .firstOrNull { modelClass.isAssignableFrom(it.key) }?.value ?: throw IllegalArgumentException("no model class")
        try {
            return getClass.get() as T
        }catch (e:Exception){
            throw RuntimeException(e)
        }
    }
}
