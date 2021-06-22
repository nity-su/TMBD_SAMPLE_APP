package com.anlyn.presentation.movie

import android.os.Bundle
import android.os.Handler
import android.text.format.Time
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.anlyn.domain.entitiy.MovieEntity
import com.anlyn.presentation.movie.adapter.MovieRelcAdapter
import com.anlyn.presentation.movie.adapter.OnLoadMoreListener
import com.anlyn.user_rating.databinding.MovieListFragmentBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MovieListFragment : Fragment() {

    companion object {
        fun newInstance() = MovieListFragment()
        fun tag() ="movie_list"
    }
    @Inject
    lateinit var viewModel: MovieListViewModel

    private lateinit var binding : MovieListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        binding = MovieListFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = MovieRelcAdapter().apply {
            movieState = viewModel.liveDataState.value
        }

        adapter.onLoadMoreListener  = object : OnLoadMoreListener(){
            override fun netLoadMore(list:MutableList<MovieEntity?>,count:Int,num:Int) {
                if(!list.contains(null)) {
                    list.add(count,null)
                    adapter.notifyItemInserted(count)
                }
                viewModel.getMovies(num)
            }
        }


        binding.recyclerView.apply {
            adapter.setRecyclerView(this)
            setAdapter(adapter)
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.liveDataState.observe(viewLifecycleOwner, Observer { state->
            if(!state.isLoading) {
                adapter.movieState = state
                adapter.setMovieEntityList(state.movieList!!.toMutableList())
            }
        })
//        viewModel.getMovies(1)
    }

}