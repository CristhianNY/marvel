package com.cristhianbonilla.data.characters.entity

import com.cristhianbonilla.domain.characters.model.CharacterResponseModel
import com.google.gson.annotations.SerializedName

data class CharacterResponseEntity(
    @SerializedName("data")
    val data: CharacterListResultEntity,
)

fun CharacterResponseEntity.toModel(): CharacterResponseModel = CharacterResponseModel(
    data.toModel()
)