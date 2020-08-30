package com.serma.fintechtestapp.di.latest

import com.serma.fintechtestapp.di.scope.FeatureScope
import com.serma.fintechtestapp.presentation.latest.LatestFragment
import dagger.Subcomponent

@Subcomponent(modules = [LatestViewModelModule::class])
@FeatureScope
interface LatestComponent {

    fun inject(latestFragment: LatestFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): LatestComponent
    }
}