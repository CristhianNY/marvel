package com.cristhianbonilla.data.characters.entity

import com.cristhianbonilla.domain.characters.model.CharacterThumbnailModel
import com.google.gson.annotations.SerializedName

data class CharacterThumbnailEntity(
    @SerializedName("extension")
    val extension: String?,
    @SerializedName("path")
    val path: String?
)

fun CharacterThumbnailEntity.toModel() = CharacterThumbnailModel(
    extension.orEmpty(), path.orEmpty()
)
