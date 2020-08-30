package com.serma.fintechtestapp.data.remote

import com.serma.fintechtestapp.data.DevLifeApi
import com.serma.fintechtestapp.data.dto.PostDto
import com.serma.fintechtestapp.data.remote.contract.RandomRemoteSource
import com.serma.fintechtestapp.domain.entitys.Post
import io.reactivex.Single
import javax.inject.Inject

class RandomRemoteSourceImpl @Inject constructor(private val api: DevLifeApi) : RandomRemoteSource {
    override fun getPost(): Single<PostDto> {
       return api.getRandomPost()
    }
}