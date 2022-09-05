package com.cristhianbonilla.data.characters.entity

import com.cristhianbonilla.domain.characters.model.CharacterUrlModel
import com.google.gson.annotations.SerializedName

data class CharacterUrlEntity(
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)

fun CharacterUrlEntity.toModel() = CharacterUrlModel(type.orEmpty(), url.orEmpty())
