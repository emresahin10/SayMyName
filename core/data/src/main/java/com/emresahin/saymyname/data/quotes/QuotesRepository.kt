package com.emresahin.saymyname.data.quotes

import com.emresahin.saymyname.Result
import com.emresahin.saymyname.model.Quote

interface QuotesRepository {
    suspend fun getQuotes(): Result<List<Quote>>
}