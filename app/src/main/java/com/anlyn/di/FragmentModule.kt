package com.anlyn.di

import com.anlyn.di.data.DataModule
import com.anlyn.di.fragment.HomeFragmentModule
import com.anlyn.di.fragment.MovieListFragModule
import com.anlyn.di.viewmodel.ViewModelModule
import com.anlyn.presentation.home.HomeFragment
import com.anlyn.presentation.movie.MovieListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope


@Module
abstract class FragmentModule{

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class, DataModule::class, ViewModelModule::class])
    abstract fun contributeHomeFragment():HomeFragment


    @ContributesAndroidInjector(modules = [MovieListFragModule::class, DataModule::class, ViewModelModule::class])
    abstract fun contributeMovieListFragment():MovieListFragment
}

@Scope
@MustBeDocumented
annotation class FragmentScope