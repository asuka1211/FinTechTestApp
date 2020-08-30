package com.serma.fintechtestapp.data.cache

import com.serma.fintechtestapp.data.NetworkRequestState
import com.serma.fintechtestapp.data.NetworkState
import com.serma.fintechtestapp.domain.entitys.Post
import com.serma.fintechtestapp.domain.repositorys.PageRepository
import com.serma.fintechtestapp.domain.repositorys.RandomRepository
import io.reactivex.Single
import java.util.ArrayList
import javax.inject.Inject

class MemoryCacheImpl @Inject constructor(
    private val repository: RandomRepository,
    private val networkState: NetworkState
) : MemoryCache {

    private val posts: ArrayList<Post> = ArrayList()
    private val loadedPosts: ArrayList<Post> = ArrayList()
    private var currentPos: Int = 0

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
        return repository.getRandomPost().map {
            posts.add(it)
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