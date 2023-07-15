package com.emresahin.saymyname.network.model

import com.emresahin.saymyname.model.Quote
import kotlinx.serialization.Serializable

@Serializable
data class NetworkQuote(
    val quoteId: String? = null,
    val quote: String? = null,
    val author: String? = null,
    val series: String? = null,
)

fun NetworkQuote.asExternal(): Quote = Quote(
    quoteId = quoteId.orEmpty(),
    quote = quote.orEmpty(),
    author = author.orEmpty(),
    series = series.orEmpty(),
)
