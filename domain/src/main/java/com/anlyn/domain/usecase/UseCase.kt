package com.anlyn.domain.usecase

import com.anlyn.domain.common.Transformer
import io.reactivex.rxjava3.core.Observable

abstract class UseCase<T>(val transformer: Transformer<T>) {
    abstract fun createObservable(data : Map<String,Any>? = null) : Observable<T>
    fun observable(data : Map<String,Any>): Observable<T>{
       return createObservable(data).compose(transformer)
    }
}