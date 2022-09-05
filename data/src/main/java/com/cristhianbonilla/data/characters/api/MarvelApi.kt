package com.cristhianbonilla.data.characters.api

import com.cristhianbonilla.data.characters.entity.CharacterResponseEntity
import retrofit2.Response
import retrofit2.http.GET

interface MarvelApi {
    @GET("public/characters")
    suspend fun getCharacterList(): Response<CharacterResponseEntity>
}
