package com.emresahin.saymyname.network.api

import com.emresahin.saymyname.network.model.NetworkCharacter
import com.emresahin.saymyname.network.model.NetworkQuote
import retrofit2.http.GET
import retrofit2.http.Path

interface SayMyNameApi {

    @GET("characters")
    suspend fun getCharacters(): List<NetworkCharacter>

    @GET("characters/{charId}")
    suspend fun getCharacter(@Path("charId") charId: String): NetworkCharacter

    @GET("quotes")
    suspend fun getQuotes(): List<NetworkQuote>
}