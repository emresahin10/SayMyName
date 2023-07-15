package com.emresahin.saymyname.quotes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuotesScreen(
    state: QuotesUiState,
    onNavigateToQuoteDetail: (quoteId: String) -> Unit,
    onNavigateBack: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(state.quotes) { index, quote ->
            QuoteListItem(
                quote = quote,
                onClick = { onNavigateToQuoteDetail(quote.quoteId) }
            )
            if (index < state.quotes.lastIndex) {
                Spacer(modifier = Modifier.height(16.dp))
                Divider()
            }
        }
    }
}