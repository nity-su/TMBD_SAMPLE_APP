package com.anlyn.di

import com.anlyn.di.data.DataModule
import com.anlyn.di.fragment.HomeFragmentModule
import com.anlyn.di.viewmodel.ViewModelModule
import com.anlyn.presentation.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope


@Module
abstract class FragmentModule{
    @FragmentScope
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class, DataModule::class, ViewModelModule::class])
    abstract fun contributeHomeFragment():HomeFragment
}

@Scope
@MustBeDocumented
annotation class FragmentScope