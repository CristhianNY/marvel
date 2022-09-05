package com.cristhianbonilla.data.characters.entity

import com.cristhianbonilla.domain.characters.model.CharacterListResultModel
import com.google.gson.annotations.SerializedName

data class CharacterListResultEntity(
    @SerializedName("results")
    val characterEntities: List<CharacterEntity>,
    @SerializedName("total")
    val total: String?
)

fun CharacterListResultEntity.toModel(): CharacterListResultModel = CharacterListResultModel(
    characterEntities.map { it.toModel() }, total.orEmpty()
)
