package com.serma.fintechtestapp.di.hot

import com.serma.fintechtestapp.di.scope.FeatureScope
import com.serma.fintechtestapp.presentation.hot.HotFragment
import dagger.Subcomponent

@Subcomponent(modules = [HotViewModelModule::class])
@FeatureScope
interface HotComponent {

    fun inject(hotFragment: HotFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): HotComponent
    }
}