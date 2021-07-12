package com.anlyn.presentation.common.adpter

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import com.anlyn.presentation.home.HomeFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

val TAG = "BindingAdapter.kt"
@BindingAdapter("movieImage")
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
//                        Log.d(TAG,e?.message.toString())
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {

                        return false
                    }
                }).error(Glide.with(fragment)
                        .load(destURl.toString()))
                .into(view)
}