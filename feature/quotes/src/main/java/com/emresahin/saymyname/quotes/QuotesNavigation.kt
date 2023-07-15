package com.emresahin.saymyname.quotes

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val quotesBaseRoute = "quotes"

fun NavGraphBuilder.quotesScreen(
    onNavigateBack: () -> Unit,
    onNavigateToQuoteDetail: (quoteId: String) -> Unit,
) = composable(
    route = quotesBaseRoute,
) {
    val viewModel: QuotesViewModel = hiltViewModel()
    val state by viewModel.viewState.collectAsState()
    QuotesScreen(
        state = state,
        onNavigateBack = onNavigateBack,
        onNavigateToQuoteDetail = onNavigateToQuoteDetail,
    )
}

fun NavController.navigateToQuotesScreen() {
    this.navigate(route = quotesBaseRoute)
}