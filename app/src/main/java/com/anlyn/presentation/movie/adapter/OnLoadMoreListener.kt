package com.anlyn.presentation.movie.adapter

import com.anlyn.domain.entitiy.MovieEntity

abstract class OnLoadMoreListener {
    abstract fun netLoadMore(list: MutableList<MovieEntity?>,count:Int, num: Int)
    fun netLoadMore(list: MutableList<MovieEntity?>, num: Int){
        netLoadMore(list,0,num)
    }
}
