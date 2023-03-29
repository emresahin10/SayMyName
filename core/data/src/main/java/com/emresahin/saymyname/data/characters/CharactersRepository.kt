package com.emresahin.saymyname.data.characters

import com.emresahin.saymyname.model.Character
import com.emresahin.saymyname.Result

interface CharactersRepository {
    suspend fun getCharacters(): Result<List<Character>>
}