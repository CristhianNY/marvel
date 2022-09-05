package com.cristhianbonilla.data.characters.entity

import com.google.gson.annotations.SerializedName

data class CharacterEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("thumbnail")
    val thumbnail: CharacterThumbnailEntity,
    @SerializedName("urls")
    val urls: List<CharacterUrlEntity>
)
