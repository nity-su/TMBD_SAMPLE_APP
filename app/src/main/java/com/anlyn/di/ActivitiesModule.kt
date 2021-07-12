package com.anlyn.di

import com.anlyn.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope


@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract fun contributeActivitiesModule(): MainActivity
}

//@Scope
//@MustBeDocumented
//annotation class ActivityScope