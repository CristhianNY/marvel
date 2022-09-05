package com.cristhianbonilla.data.characters.entity

import com.google.gson.annotations.SerializedName

data class CharacterUrlEntity(
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)
