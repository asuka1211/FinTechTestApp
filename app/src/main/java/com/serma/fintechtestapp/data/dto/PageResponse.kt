package com.serma.fintechtestapp.data.dto

import com.google.gson.annotations.SerializedName

data class PageResponse(@SerializedName("result") val list: List<PostDto>)