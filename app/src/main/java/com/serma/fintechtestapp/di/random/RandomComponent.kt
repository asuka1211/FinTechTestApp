package com.serma.fintechtestapp.di.random

import com.serma.fintechtestapp.di.scope.FeatureScope
import com.serma.fintechtestapp.presentation.random.RandomFragment
import dagger.Subcomponent

@Subcomponent(modules = [RandomViewModelModule::class])
@FeatureScope
interface RandomComponent {

    fun inject(randomFragment: RandomFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): RandomComponent
    }
}