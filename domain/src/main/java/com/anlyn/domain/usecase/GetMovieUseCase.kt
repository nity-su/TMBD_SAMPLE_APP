package com.anlyn.domain.usecase

import com.anlyn.domain.Repository
import com.anlyn.domain.common.Transformer
import com.anlyn.domain.entitiy.MovieEntity
import io.reactivex.rxjava3.core.Observable


// 생성자에서 val ,var 제외하면 무슨 의미일까?
class GetMovieUseCase(transformer:Transformer<List<MovieEntity>>,private val repo:Repository) : UseCase<List<MovieEntity>>(transformer){
    private val LANGUAGE_KEY="language"
    private val PAGE_KEY="page"
    fun execute(language:String,page:Int):Observable<List<MovieEntity>>{
         val data =HashMap<String,Any>()
             data[LANGUAGE_KEY] = language
             data[PAGE_KEY] = page
             return observable(data)
    }

    override fun createObservable(data: Map<String, Any>?): Observable<List<MovieEntity>> {
        val language = data?.get(LANGUAGE_KEY) as String
        val page = data?.get(PAGE_KEY) as Int
       return repo.getMovies(language,page)
    }
}