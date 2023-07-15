package com.emresahin.saymyname.network.source.quotes

import com.emresahin.saymyname.Result
import com.emresahin.saymyname.model.Quote

interface QuotesNetworkDataSource {
    suspend fun getQuotes(): Result<List<Quote>>
}