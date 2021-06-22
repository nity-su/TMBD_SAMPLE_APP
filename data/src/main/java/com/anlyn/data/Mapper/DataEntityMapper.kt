package com.anlyn.data.Mapper

import com.anlyn.data.MovieData
import com.anlyn.domain.Mapper
import com.anlyn.domain.entitiy.MovieEntity

class DataEntityMapper : Mapper<MovieData,MovieEntity>(){
    override fun mapFrom(from: MovieData): MovieEntity {
        return MovieEntity(title = from.title,url = from.poster_path,rating = ratingScoreToStars(from.vote_average))
    }
    private fun ratingScoreToStars(rating:String):Int{
        return rating.toFloat().let {
            if(it>8.0) {
                3
            }
            else if(it>6.0) {
                2
            }else{
                1
            }
        }
    }
}