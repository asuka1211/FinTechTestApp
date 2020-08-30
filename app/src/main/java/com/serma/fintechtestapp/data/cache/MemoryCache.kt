package com.serma.fintechtestapp.data.cache

import com.serma.fintechtestapp.domain.entitys.Post
import io.reactivex.Single

interface MemoryCache {
    fun getNext(): Single<Post>
    fun getPrevious(): Post
    fun getCurrent(): Single<Post>
    fun getCurrentPos(): Int
}