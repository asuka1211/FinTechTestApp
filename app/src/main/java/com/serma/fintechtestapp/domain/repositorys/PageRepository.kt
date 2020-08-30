package com.serma.fintechtestapp.domain.repositorys

import com.serma.fintechtestapp.domain.entitys.Post
import io.reactivex.Single

interface PageRepository {
    fun getPosts(page: Int): Single<List<Post>>
}