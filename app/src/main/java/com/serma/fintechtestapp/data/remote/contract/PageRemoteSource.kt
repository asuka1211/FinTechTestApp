package com.serma.fintechtestapp.data.remote.contract

import com.serma.fintechtestapp.data.dto.PageResponse
import com.serma.fintechtestapp.domain.entitys.Post
import io.reactivex.Single

interface PageRemoteSource {
    fun getPosts(page: Int): Single<PageResponse>
}