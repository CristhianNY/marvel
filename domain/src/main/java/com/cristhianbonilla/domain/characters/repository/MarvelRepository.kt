package com.cristhianbonilla.domain.characters.repository

import com.cristhianbonilla.domain.characters.model.CharacterResponseModel
import com.cristhianbonilla.support.config.ResultDomain

interface MarvelRepository {
    suspend fun getCharacterList(): ResultDomain<CharacterResponseModel>
}