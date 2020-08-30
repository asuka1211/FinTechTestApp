package com.serma.fintechtestapp.di

import android.content.Context
import com.serma.fintechtestapp.di.best.BestComponent
import com.serma.fintechtestapp.di.hot.HotComponent
import com.serma.fintechtestapp.di.latest.LatestComponent
import com.serma.fintechtestapp.di.random.RandomComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class,
    ViewModelFactoryModule::class])
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun registerLatestComponent(): LatestComponent.Factory

    fun registerHotComponent(): HotComponent.Factory

    fun registerBestComponent(): BestComponent.Factory

    fun registerRandomComponent(): RandomComponent.Factory
}