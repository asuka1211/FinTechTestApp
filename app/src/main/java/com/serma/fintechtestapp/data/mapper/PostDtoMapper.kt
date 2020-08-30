package com.serma.fintechtestapp.data.mapper

import com.serma.fintechtestapp.data.dto.PostDto
import com.serma.fintechtestapp.domain.entitys.Post
import com.serma.fintechtestapp.data.NetworkRequestState

class PostDtoMapper {

    fun toEntity(postDto: PostDto): Post {
        return Post(postDto.desc, postDto.gif, NetworkRequestState.SUCCESS)
    }
}