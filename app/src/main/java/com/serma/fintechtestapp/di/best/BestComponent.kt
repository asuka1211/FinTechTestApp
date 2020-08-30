package com.serma.fintechtestapp.di.best

import com.serma.fintechtestapp.di.scope.FeatureScope
import com.serma.fintechtestapp.presentation.best.BestFragment
import dagger.Subcomponent

@Subcomponent(modules = [BestViewModelModule::class])
@FeatureScope
interface BestComponent {

    fun inject(bestFragment: BestFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): BestComponent
    }
}