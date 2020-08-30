package com.serma.fintechtestapp.di.hot

import androidx.lifecycle.ViewModel
import com.serma.fintechtestapp.data.cache.MemoryCache
import com.serma.fintechtestapp.data.cache.MemoryCachePageImpl
import com.serma.fintechtestapp.data.mapper.PostDtoMapper
import com.serma.fintechtestapp.data.remote.HotRemoteSourceImpl
import com.serma.fintechtestapp.data.remote.contract.PageRemoteSource
import com.serma.fintechtestapp.data.repository.PageRepositoryImpl
import com.serma.fintechtestapp.di.scope.FeatureScope
import com.serma.fintechtestapp.di.keys.ViewModelKey
import com.serma.fintechtestapp.domain.repositorys.PageRepository
import com.serma.fintechtestapp.presentation.hot.HotViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap

@Module
abstract class HotViewModelModule {

    @ViewModelKey(HotViewModel::class)
    @FeatureScope
    @IntoMap
    @Binds
    abstract fun bindsLatestViewModule(hotViewModel: HotViewModel): ViewModel

    @Binds
    @FeatureScope
    abstract fun bindsPageRepository(pageRepositoryImpl: PageRepositoryImpl): PageRepository

    @Binds
    @FeatureScope
    abstract fun bindsPageRemoteSource(pageRemoteSourceImpl: HotRemoteSourceImpl): PageRemoteSource

    @Binds
    @FeatureScope
    abstract fun bindsMemoryCache(memoryCachePageImpl: MemoryCachePageImpl): MemoryCache

    companion object {
        @Reusable
        @Provides
        fun provideMapper(): PostDtoMapper {
            return PostDtoMapper()
        }
    }

}