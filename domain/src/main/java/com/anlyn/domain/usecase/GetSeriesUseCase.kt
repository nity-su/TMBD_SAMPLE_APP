package com.anlyn.domain.usecase

import com.anlyn.domain.Repository
import com.anlyn.domain.common.Transformer
import com.anlyn.domain.entitiy.SeriesEntity
import io.reactivex.rxjava3.core.Observable

class GetSeriesUseCase(transformer: Transformer<List<SeriesEntity>>,private val repo:Repository) : UseCase<List<SeriesEntity>>(transformer) {

    private val LANGUAGE_KEY="language"
    private val PAGE_KEY="page"

    override fun createObservable(data: Map<String, Any>?): Observable<List<SeriesEntity>> {

            val language = data?.get(LANGUAGE_KEY) as String
            val page = data.get(PAGE_KEY) as Int
            return repo.getSeries(language,page)

    }

    fun execute(language:String,page:Int):Observable<List<SeriesEntity>>{
        val map = HashMap<String,Any>()
        map[LANGUAGE_KEY] = language
        map[PAGE_KEY] = page
        return observable(map)

    }
}