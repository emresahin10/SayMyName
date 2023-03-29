package com.emresahin.saymyname.network.source.characters

import com.emresahin.saymyname.model.Character
import com.emresahin.saymyname.Result
import com.emresahin.saymyname.mapData
import com.emresahin.saymyname.network.SayMyNameApiCall
import com.emresahin.saymyname.network.api.SayMyNameApi
import com.emresahin.saymyname.network.model.NetworkCharacter
import com.emresahin.saymyname.network.model.asExternal
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject

@Bound
class CharactersNetworkDataSourceImpl @Inject constructor(
    private val sayMyNameApi: SayMyNameApi,
    private val sayMyNameApiCall: SayMyNameApiCall,
) : CharactersNetworkDataSource {

    override suspend fun getCharacters(): Result<List<Character>> {
        return sayMyNameApiCall { sayMyNameApi.getCharacters() }.mapData {
            it?.map(NetworkCharacter::asExternal).orEmpty()
        }
    }
}