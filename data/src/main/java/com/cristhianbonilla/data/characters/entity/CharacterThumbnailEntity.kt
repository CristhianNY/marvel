package com.cristhianbonilla.data.characters.entity

import com.google.gson.annotations.SerializedName

data class CharacterThumbnailEntity(
    @SerializedName("extension")
    val extension: String,
    @SerializedName("path")
    val path: String
)
