package com.serma.fintechtestapp.data.repository

import com.serma.fintechtestapp.data.mapper.PostDtoMapper
import com.serma.fintechtestapp.data.remote.contract.PageRemoteSource
import com.serma.fintechtestapp.data.remote.contract.RandomRemoteSource
import com.serma.fintechtestapp.domain.entitys.Post
import com.serma.fintechtestapp.domain.repositorys.RandomRepository
import io.reactivex.Single
import javax.inject.Inject

class RandomRepositoryImpl @Inject constructor(
    private val randomRemoteSource: RandomRemoteSource,
    private val postDtoMapper: PostDtoMapper
) : RandomRepository {
    override fun getRandomPost(): Single<Post> {
        return randomRemoteSource.getPost().map { postDtoMapper.toEntity(it) }
    }
}