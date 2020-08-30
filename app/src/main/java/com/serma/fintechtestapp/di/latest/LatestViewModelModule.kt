package com.serma.fintechtestapp.di.latest

import androidx.lifecycle.ViewModel
import com.serma.fintechtestapp.data.cache.MemoryCache
import com.serma.fintechtestapp.data.cache.MemoryCachePageImpl
import com.serma.fintechtestapp.data.mapper.PostDtoMapper
import com.serma.fintechtestapp.data.remote.LatestRemoteSourceImpl
import com.serma.fintechtestapp.data.remote.contract.PageRemoteSource
import com.serma.fintechtestapp.data.repository.PageRepositoryImpl
import com.serma.fintechtestapp.di.scope.FeatureScope
import com.serma.fintechtestapp.di.keys.ViewModelKey
import com.serma.fintechtestapp.domain.repositorys.PageRepository
import com.serma.fintechtestapp.presentation.latest.LatestViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap

@Module
abstract class LatestViewModelModule {

    @ViewModelKey(LatestViewModel::class)
    @FeatureScope
    @IntoMap
    @Binds
    abstract fun bindsLatestViewModule(latestViewModel: LatestViewModel): ViewModel

    @FeatureScope
    @Binds
    abstract fun bindsPageRepository(pageRepositoryImpl: PageRepositoryImpl): PageRepository

    @FeatureScope
    @Binds
    abstract fun bindsPageRemoteSource(pageRemoteSourceImpl: LatestRemoteSourceImpl): PageRemoteSource

    @FeatureScope
    @Binds
    abstract fun bindsMemoryCache(memoryCachePageImpl: MemoryCachePageImpl): MemoryCache

    companion object {
        @Reusable
        @Provides
        fun provideMapper(): PostDtoMapper {
            return PostDtoMapper()
        }
    }

}