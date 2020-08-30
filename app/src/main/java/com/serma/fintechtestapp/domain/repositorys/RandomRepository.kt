package com.serma.fintechtestapp.domain.repositorys

import com.serma.fintechtestapp.domain.entitys.Post
import io.reactivex.Single

interface RandomRepository {
    fun getRandomPost(): Single<Post>
}