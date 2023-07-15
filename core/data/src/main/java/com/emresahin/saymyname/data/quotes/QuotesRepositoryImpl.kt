package com.emresahin.saymyname.data.quotes

import com.emresahin.saymyname.Result
import com.emresahin.saymyname.model.Quote
import com.emresahin.saymyname.network.source.quotes.QuotesNetworkDataSource
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject
import javax.inject.Singleton

@Bound
@Singleton
class QuotesRepositoryImpl @Inject constructor(
    private val quotesNetworkDataSource: QuotesNetworkDataSource,
) : QuotesRepository {

    override suspend fun getQuotes(): Result<List<Quote>> {
        return quotesNetworkDataSource.getQuotes()
    }
}