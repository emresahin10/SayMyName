package com.emresahin.saymyname.network.source.characters

import com.emresahin.saymyname.Result
import com.emresahin.saymyname.model.Character

interface CharactersNetworkDataSource {
    suspend fun getCharacters(): Result<List<Character>>
    suspend fun getCharacter(charId: String): Result<Character>
}