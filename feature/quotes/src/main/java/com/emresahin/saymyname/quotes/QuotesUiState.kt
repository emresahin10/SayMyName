package com.emresahin.saymyname.quotes

import com.emresahin.saymyname.model.Quote

data class QuotesUiState(
    val quotes: List<Quote> = emptyList(),
)
