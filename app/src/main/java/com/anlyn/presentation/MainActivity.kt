package com.anlyn.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.anlyn.user_rating.R
import com.anlyn.presentation.home.HomeFragment
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
        manger.add(R.id.mActivityConr, HomeFragment.newInstance(), HomeFragment.tag())
        manger.commit()
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount

        Log.d("mianActivity",count.toString())
        if(count==0)
            super.onBackPressed()
        else
            supportFragmentManager.popBackStack()
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}