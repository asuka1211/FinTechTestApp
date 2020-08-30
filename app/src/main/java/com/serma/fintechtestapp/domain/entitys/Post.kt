package com.serma.fintechtestapp.domain.entitys

import com.serma.fintechtestapp.data.NetworkRequestState

data class Post(
    val description: String = "",
    val gifUrl: String = "",
    val networkRequestState: NetworkRequestState
)