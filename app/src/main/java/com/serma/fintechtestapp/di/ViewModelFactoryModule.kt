package com.serma.fintechtestapp.di

import androidx.lifecycle.ViewModelProvider
import com.serma.fintechtestapp.presentation.factory.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindsViewModelFactory(daggerViewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}