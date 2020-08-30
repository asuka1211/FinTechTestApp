package com.serma.fintechtestapp.domain.usecases

import com.serma.fintechtestapp.data.cache.MemoryCache
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val cache: MemoryCache) {

    fun getNext() = cache.getNext()

    fun getPrevious() = cache.getPrevious()

    fun getCurrentPost() = cache.getCurrentPos()

    fun getCurrent() = cache.getCurrent()
}