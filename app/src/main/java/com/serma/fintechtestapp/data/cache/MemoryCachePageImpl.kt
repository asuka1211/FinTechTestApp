package com.serma.fintechtestapp.data.cache

import com.serma.fintechtestapp.data.NetworkRequestState
import com.serma.fintechtestapp.data.NetworkState
import com.serma.fintechtestapp.domain.entitys.Post
import com.serma.fintechtestapp.domain.repositorys.PageRepository
import io.reactivex.Single
import java.util.ArrayList
import javax.inject.Inject

class MemoryCachePageImpl @Inject constructor(
    private val repository: PageRepository,
    private val networkState: NetworkState
) : MemoryCache {

    private val posts: ArrayList<Post> = ArrayList()
    private var currentPos: Int = 0
    private var currentPage: Int = 0

    override fun getNext(): Single<Post> {
        currentPos++
        return getPost()
    }

    override fun getPrevious(): Post {
        currentPos--
        return posts[currentPos]
    }

    override fun getCurrent(): Single<Post> {
        return getPost()
    }

    override fun getCurrentPos(): Int {
        return currentPos
    }

    private fun getFromNetwork(): Single<Post> {
        return repository.getPosts(page = currentPage).map {
            currentPage++
            posts.addAll(it)
            posts[currentPos]
        }
    }

    private fun getPost(): Single<Post> {
        return when {
            posts.size > currentPos -> {
                Single.just(posts[currentPos])
            }
            networkState.isOnline() -> {
                getFromNetwork()
            }
            else -> {
                Single.just(Post(networkRequestState = NetworkRequestState.ERROR))
            }
        }
    }

}