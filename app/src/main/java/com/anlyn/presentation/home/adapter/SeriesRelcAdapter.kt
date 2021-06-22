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
import com.anlyn.domain.entitiy.SeriesEntity
import com.anlyn.user_rating.R
import com.anlyn.presentation.home.HomeFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class SeriesRelcAdapter : RecyclerView.Adapter<SeriesRelcAdapter.ViewHolder>(){
    private var list:List<SeriesEntity> = emptyList()
    fun setList(_list:List<SeriesEntity>){
        list = _list;
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater,R.layout.home_frag_series_cell,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        if(!list.isEmpty())
            return 6;
        else
            return 0;
    }

    class ViewHolder(val view:ViewDataBinding) : RecyclerView.ViewHolder(view.root){
        fun bind(any:Any){
            view.setVariable(BR.series,any)
        }
    }

    companion object {
        @BindingAdapter("seriesImage")
        @JvmStatic
        fun bindCurrency(view: ImageView, imageUrl: String) {
            val fragment = view.context.let {
                (it as AppCompatActivity).supportFragmentManager.findFragmentByTag(HomeFragment.tag())
            }
            var destURl = StringBuilder().append("https://image.tmdb.org/t/p/w92").append(imageUrl)

            if(fragment!=null && !imageUrl.isNullOrEmpty())
                Glide.with(fragment)
                        .load(destURl.toString())
                        .listener(object : RequestListener<Drawable> {
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