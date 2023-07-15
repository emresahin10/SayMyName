package com.emresahin.saymyname.network.source.quotes

import com.emresahin.saymyname.Result
import com.emresahin.saymyname.mapData
import com.emresahin.saymyname.model.Quote
import com.emresahin.saymyname.network.SayMyNameApiCall
import com.emresahin.saymyname.network.api.SayMyNameApi
import com.emresahin.saymyname.network.model.NetworkQuote
import com.emresahin.saymyname.network.model.asExternal
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject

@Bound
class QuotesNetworkDataSourceImpl @Inject constructor(
    private val sayMyNameApi: SayMyNameApi,
    private val sayMyNameApiCall: SayMyNameApiCall,
) : QuotesNetworkDataSource {

    override suspend fun getQuotes(): Result<List<Quote>> {
        return sayMyNameApiCall { sayMyNameApi.getQuotes() }
            .mapData { it?.map(NetworkQuote::asExternal).orEmpty() }
    }
}