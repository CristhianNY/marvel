package com.cristhianbonilla.data.characters.entity

import com.google.gson.annotations.SerializedName

data class CharacterResponseEntity(
    @SerializedName("data")
    val data: CharacterListResultEntity,
)
