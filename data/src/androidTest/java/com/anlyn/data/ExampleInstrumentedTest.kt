package com.anlyn.data

import android.os.Looper
import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.anlyn.data.remote.api.TDMBApi
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Before
    fun retrofitTest(){
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val api = retrofit.create(TDMBApi::class.java)
        api.getPopularMovies("d63067c42f53b7d5aa1a067c2fc2ab07","ko",1)
            .observeOn(Schedulers.newThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d("size:",it.list.size.toString())
            },{
                Log.d("error:",it.message)
            })

    }
    @Test
    fun useAppContext() {
        // Context of the app under test.

        Looper.prepare()

        Looper.loop()
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.anlyn.data.test", appContext.packageName)
    }
}