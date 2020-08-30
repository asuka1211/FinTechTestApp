package com.serma.fintechtestapp.data.repository

import com.serma.fintechtestapp.data.mapper.PostDtoMapper
import com.serma.fintechtestapp.data.remote.contract.PageRemoteSource
import com.serma.fintechtestapp.domain.entitys.Post
import com.serma.fintechtestapp.domain.repositorys.PageRepository
import io.reactivex.Single
import javax.inject.Inject

class PageRepositoryImpl @Inject constructor(
    private val pageRemoteSource: PageRemoteSource,
    private val postDtoMapper: PostDtoMapper
) : PageRepository {
    override fun getPosts(page: Int): Single<List<Post>> {
        return pageRemoteSource.getPosts(page).map { result -> result.list }
            .map { list -> list.map { postDtoMapper.toEntity(it) } }
    }
}