package com.serma.fintechtestapp.data.remote

import com.serma.fintechtestapp.data.DevLifeApi
import com.serma.fintechtestapp.data.dto.PageResponse
import com.serma.fintechtestapp.data.remote.contract.PageRemoteSource
import io.reactivex.Single
import javax.inject.Inject

class HotRemoteSourceImpl @Inject constructor(private val api: DevLifeApi): PageRemoteSource {
    override fun getPosts(page: Int): Single<PageResponse> {
        return api.getHotPosts(page)
    }
}