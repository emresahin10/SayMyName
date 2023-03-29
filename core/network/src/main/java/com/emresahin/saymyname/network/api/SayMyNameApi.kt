package com.emresahin.saymyname.network.api

import com.emresahin.saymyname.network.model.NetworkCharacter
import retrofit2.http.GET

interface SayMyNameApi {

    @GET("api/characters")
    suspend fun getCharacters(): List<NetworkCharacter>
}