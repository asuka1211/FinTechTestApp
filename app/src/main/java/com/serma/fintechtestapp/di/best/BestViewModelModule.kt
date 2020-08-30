package com.serma.fintechtestapp.di.best

import androidx.lifecycle.ViewModel
import com.serma.fintechtestapp.data.cache.MemoryCache
import com.serma.fintechtestapp.data.cache.MemoryCachePageImpl
import com.serma.fintechtestapp.data.mapper.PostDtoMapper
import com.serma.fintechtestapp.data.remote.BestRemoteSourceImpl
import com.serma.fintechtestapp.data.remote.contract.PageRemoteSource
import com.serma.fintechtestapp.data.repository.PageRepositoryImpl
import com.serma.fintechtestapp.di.scope.FeatureScope
import com.serma.fintechtestapp.di.keys.ViewModelKey
import com.serma.fintechtestapp.domain.repositorys.PageRepository
import com.serma.fintechtestapp.presentation.best.BestViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap

@Module
abstract class BestViewModelModule {

    @ViewModelKey(BestViewModel::class)
    @FeatureScope
    @IntoMap
    @Binds
    abstract fun bindsBestViewModule(bestViewModel: BestViewModel): ViewModel

    @Binds
    @FeatureScope
    abstract fun bindsPageRepository(pageRepositoryImpl: PageRepositoryImpl): PageRepository

    @Binds
    @FeatureScope
    abstract fun bindsPageRemoteSource(bestRemoteSourceImpl: BestRemoteSourceImpl): PageRemoteSource

    @Binds
    @FeatureScope
    abstract fun bindsMemoryCache(memoryCachePageImpl: MemoryCachePageImpl): MemoryCache

    companion object {
        @Provides
        @Reusable
        fun provideMapper(): PostDtoMapper {
            return PostDtoMapper()
        }
    }

}