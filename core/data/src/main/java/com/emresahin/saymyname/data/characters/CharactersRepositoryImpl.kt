package com.emresahin.saymyname.data.characters

import com.emresahin.saymyname.Result
import com.emresahin.saymyname.model.Character
import com.emresahin.saymyname.network.source.characters.CharactersNetworkDataSource
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject
import javax.inject.Singleton

@Bound
@Singleton
class CharactersRepositoryImpl @Inject constructor(
    private val charactersNetworkDataSource: CharactersNetworkDataSource,
) : CharactersRepository {

    override suspend fun getCharacters(): Result<List<Character>> {
        return charactersNetworkDataSource.getCharacters()
    }

    override suspend fun getCharacter(charId: String): Result<Character> {
        return charactersNetworkDataSource.getCharacter(charId)
    }
}