package com.anlyn.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.anlyn.netflixmovie.R
import dagger.android.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() ,HasAndroidInjector  {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        val manger = supportFragmentManager.beginTransaction()
        manger.add(R.id.mActivityConr,HomeFragment.newInstance(),HomeFragment.tag())
        manger.commit()
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}