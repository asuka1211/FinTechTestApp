package com.serma.fintechtestapp.data.remote.contract

import com.serma.fintechtestapp.data.dto.PostDto
import com.serma.fintechtestapp.domain.entitys.Post
import io.reactivex.Single

interface RandomRemoteSource {
    fun getPost(): Single<PostDto>
}