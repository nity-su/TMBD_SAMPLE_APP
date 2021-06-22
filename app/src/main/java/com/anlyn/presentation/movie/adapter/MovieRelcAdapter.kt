package com.anlyn.presentation.movie.adapter

import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anlyn.domain.entitiy.MovieEntity
import com.anlyn.presentation.movie.MovieViewState
import com.anlyn.user_rating.BR
import com.anlyn.user_rating.R
import javax.inject.Inject

class MovieRelcAdapter : RecyclerView.Adapter<MovieRelcAdapter.BaseViewHolder>() {

    private val TAG = "MovieRelcAdapter"
    var list: MutableList<MovieEntity?> = mutableListOf()
    private val ITEM_TYPE = 1
    private val PROGRESS_TYPE=2
    private val LIMIT_SIZE=9
    private var page=1
    private var itemCount=1
    private var state: MovieRelcAdapterState = MovieRelcAdapterState.initData
    var movieState:MovieViewState? = null
    lateinit var onLoadMoreListener: OnLoadMoreListener

    init {
        list.add(null)
        notifyItemInserted(0)
    }

    fun setMovieEntityList(_list: MutableList<MovieEntity?>) {


        if(_list!=null)
            Handler().postDelayed(
                Runnable {
                    stopProgressBar(list.indexOf(null)+1)
                    _list.iterator().forEach {
                        list.add(it)
                    }
                },2000L)

    }

    fun setRecyclerView(recyclerView: RecyclerView){

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val manger = recyclerView.layoutManager as LinearLayoutManager
                if(movieState!=null && !movieState!!.isLoading) {
                    if (manger != null &&
                        manger.findLastCompletelyVisibleItemPosition() ==  (itemCount*9-1)
                    ) {
                        state = checkState()
                        when(state){
                            MovieRelcAdapterState.loadRemoteData -> {
                                page += 1
                                //list.add를 itemcount 보다 먼저
                                movieState!!.isLoading = true
                                onLoadMoreListener?.netLoadMore(list!!,itemCount*LIMIT_SIZE, page).also {
                                    itemCount+=1
                                }
                            }
                            MovieRelcAdapterState.loadCachedData -> {
                                list.add(itemCount*LIMIT_SIZE,null)
                                notifyItemInserted(itemCount*LIMIT_SIZE)
                                movieState!!.isLoading = true
                                Handler().postDelayed(Runnable {
                                    itemCount+=1
                                    stopProgressBar(list.indexOf(null)+1)
                                },2000)
                            }
                        }

                    }
                }else if(state.equals(MovieRelcAdapterState.initData)){
                    onLoadMoreListener?.netLoadMore(list!!,0, page)
                    movieState!!.isLoading = true
                }
            }
        })
    }

    private fun checkState():MovieRelcAdapterState{

        if(page*20<(itemCount+1)*LIMIT_SIZE)
           return MovieRelcAdapterState.loadRemoteData
        else
            return MovieRelcAdapterState.loadCachedData

    }

    private fun stopProgressBar(size:Int){

        list.removeAt(size-1)
        this.notifyItemRemoved(size-1)
        movieState?.isLoading = false
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        if(viewType == ITEM_TYPE) {
            val inflater = LayoutInflater.from(parent.context)
            val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.list_frag_movie_cell, parent, false)
            return MovieViewHolder(binding)
        }else {
            val inflater = LayoutInflater.from(parent.context)
            val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.progress_bar, parent, false)
            return ProcessViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
           list.get(position)?.let { holder.bind(it) }

    }

    override fun getItemCount(): Int {

        if(list.contains(null) && list.size>itemCount*LIMIT_SIZE){
            val index = list.indexOf(null)+1
            return index
        }

        if(list.size>itemCount*LIMIT_SIZE) {
            return itemCount * LIMIT_SIZE
        }

        if(list.contains(null)) {
            val index = list.indexOf(null)+1
            return index
        }

        return list.size
        //if(list.size<itemCount*9)
    }

    override fun getItemViewType(position: Int): Int {
       return list?.get(position).let {
           if(it!=null){
               ITEM_TYPE
           }else{
               PROGRESS_TYPE
           }
       }
    }

    class MovieViewHolder(val view:ViewDataBinding) : BaseViewHolder(view.root){
        override fun bind(any:Any){
            view.setVariable(BR.movieInfo,any)
        }

    }
    class ProcessViewHolder(val view:ViewDataBinding) : BaseViewHolder(view.root){
       override fun bind(any:Any){}
    }

     abstract class BaseViewHolder(view: View):RecyclerView.ViewHolder(view.rootView){
        abstract fun bind(any:Any)
    }
}