package com.anlyn.di

import android.app.Application
import com.anlyn.AppApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class,ActivitiesModule::class,FragmentModule::class))
interface MainComponent  {
    fun inject(application:AppApplication )

    @Component.Builder
    interface Builder{
        fun build():MainComponent

        @BindsInstance fun bindApplication(application: Application):Builder

    }

}
