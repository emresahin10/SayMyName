package com.emresahin.saymyname.network.source.characters

import com.emresahin.saymyname.model.Character
import com.emresahin.saymyname.Result

interface CharactersNetworkDataSource {
    suspend fun getCharacters(): Result<List<Character>>
}