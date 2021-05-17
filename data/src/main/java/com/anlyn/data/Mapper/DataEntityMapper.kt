package com.anlyn.data.Mapper

import com.anlyn.data.MovieData
import com.anlyn.domain.Mapper
import com.anlyn.domain.entitiy.MovieEntity

class DataEntityMapper : Mapper<MovieData,MovieEntity>(){
    override fun mapFrom(from: MovieData): MovieEntity {
        return MovieEntity(title = from.title,url = from.poster_path,0)
    }
}