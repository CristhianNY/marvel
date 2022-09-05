package com.cristhianbonilla.data.characters.entity

import com.google.gson.annotations.SerializedName

data class CharacterListResultEntity(
    @SerializedName("results")
    val characterEntities: List<CharacterEntity>,
    @SerializedName("total")
    val total: String
)
