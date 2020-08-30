package com.serma.fintechtestapp.data

import com.serma.fintechtestapp.data.dto.PageResponse
import com.serma.fintechtestapp.data.dto.PostDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface DevLifeApi {

    @GET("random?json=true")
    fun getRandomPost(): Single<PostDto>

    @GET("hot/{page}?json=true")
    fun getHotPosts(@Path("page") page: Int): Single<PageResponse>

    @GET("latest/{page}?json=true")
    fun getLatestPosts(@Path("page") page: Int): Single<PageResponse>

    @GET("top/{page}?json=true")
    fun getBestPosts(@Path("page") page: Int): Single<PageResponse>
}