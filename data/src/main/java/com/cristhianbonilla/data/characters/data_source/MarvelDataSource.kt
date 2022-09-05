package com.cristhianbonilla.data.characters.data_source

import com.cristhianbonilla.data.characters.entity.CharacterResponseEntity
import com.cristhianbonilla.support.config.Result

interface MarvelDataSource {
    suspend fun getCharacterList(): Result<CharacterResponseEntity>
}
