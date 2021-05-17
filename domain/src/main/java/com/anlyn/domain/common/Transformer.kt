package com.anlyn.domain.common

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.core.ObservableTransformer

abstract class Transformer<T> : ObservableTransformer<T, T>