package com.anlyn.netflixmovie

import android.os.Looper
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anlyn.data.RetrofitTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.

        Looper.prepare()
        Looper.loop()

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.anlyn.netflixmovie", appContext.packageName)
    }
}