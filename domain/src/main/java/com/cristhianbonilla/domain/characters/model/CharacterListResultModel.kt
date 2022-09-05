package com.cristhianbonilla.domain.characters.model

data class CharacterListResultModel(
    val characterEntities: List<CharacterModel>,
    val total: String
)
