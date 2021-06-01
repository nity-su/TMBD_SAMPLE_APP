package com.anlyn.presentation.home.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.anlyn.domain.entitiy.MovieEntity
import com.anlyn.netflixmovie.R
import com.anlyn.presentation.home.HomeFragment
import com.anlyn.presentation.home.listener.OnHomeFragListener
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class MovieRelcAdapter(val listener: OnHomeFragListener) : RecyclerView.Adapter<MovieRelcAdapter.ViewHolder>(){
    private val MovieType:Int = 1;
    private val NextButton:Int = 2;

    private var list:List<MovieEntity> = emptyList()

    fun setList(entities:List<MovieEntity>) {
        list=entities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding : ViewDataBinding
        val inflater = LayoutInflater.from(parent.context)
        if(viewType == MovieType) {
            binding = DataBindingUtil.inflate<ViewDataBinding>(inflater,
                    R.layout.home_frag_video_cell, parent, false)
            return ViewHolder(binding);
        }

        binding = DataBindingUtil.inflate<ViewDataBinding>(inflater,
            R.layout.home_relc_next_button,parent,false)
        return ViewHolder(binding);

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(position<6)
        holder.bind(list.get(position))
        if(position==6)
            holder.nextBtnBind(listener)
    }

    override fun getItemCount(): Int{
        if(list.isNotEmpty()){
            return 7
        }else{
            return 0
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(position<6)
            return 1
        else
            return 2
    }

    class ViewHolder(val binding:ViewDataBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(movie:Any){
            binding.setVariable(BR.movie,movie)
        }

        fun nextBtnBind(listener: OnHomeFragListener){
            binding.setVariable(BR.listener,listener)
        }
    }


    companion object {
        @BindingAdapter("movieImage")
        @JvmStatic
        fun bindCurrency(view: ImageView, imageUrl: String) {
            val fragment = view.context.let {
                (it as AppCompatActivity).supportFragmentManager.findFragmentByTag(HomeFragment.tag())
            }
            var destURl = StringBuilder().append("https://image.tmdb.org/t/p/w92").append(imageUrl)

            if(fragment!=null && !imageUrl.isNullOrEmpty())
            Glide.with(fragment)
                    .load(destURl.toString())
                    .listener(object : RequestListener<Drawable>{
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                            TODO("Not yet implemented")
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {

                            return false
                        }
                    })
                    .into(view)
        }
    }

}

