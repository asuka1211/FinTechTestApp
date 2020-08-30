package com.serma.fintechtestapp.data.dto

import com.google.gson.annotations.SerializedName

data class PostDto(
    @SerializedName("description") val desc: String,
    @SerializedName("gifURL") val gif: String
)