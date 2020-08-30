package com.serma.fintechtestapp.di.random

import androidx.lifecycle.ViewModel
import com.serma.fintechtestapp.data.cache.MemoryCache
import com.serma.fintechtestapp.data.cache.MemoryCacheImpl
import com.serma.fintechtestapp.data.mapper.PostDtoMapper
import com.serma.fintechtestapp.data.remote.RandomRemoteSourceImpl
import com.serma.fintechtestapp.data.remote.contract.RandomRemoteSource
import com.serma.fintechtestapp.data.repository.RandomRepositoryImpl
import com.serma.fintechtestapp.di.scope.FeatureScope
import com.serma.fintechtestapp.di.keys.ViewModelKey
import com.serma.fintechtestapp.domain.repositorys.RandomRepository
import com.serma.fintechtestapp.presentation.random.RandomViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap

@Module
abstract class RandomViewModelModule {

    @ViewModelKey(RandomViewModel::class)
    @FeatureScope
    @IntoMap
    @Binds
    abstract fun bindsBestViewModule(randomViewModel: RandomViewModel): ViewModel

    @Binds
    @FeatureScope
    abstract fun bindsPageRepository(randomRepositoryImpl: RandomRepositoryImpl): RandomRepository

    @Binds
    @FeatureScope
    abstract fun bindsPageRemoteSource(randomRemoteSourceImpl: RandomRemoteSourceImpl): RandomRemoteSource

    @Binds
    @FeatureScope
    abstract fun bindsMemoryCache(memoryCacheImpl: MemoryCacheImpl): MemoryCache

    companion object {
        @Provides
        @Reusable
        fun provideMapper(): PostDtoMapper {
            return PostDtoMapper()
        }
    }

}