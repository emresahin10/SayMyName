package com.emresahin.saymyname.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.emresahin.saymyname.character_detail.characterDetailScreen
import com.emresahin.saymyname.character_detail.navigateToCharacterDetailScreen
import com.emresahin.saymyname.characters.charactersBaseRoute
import com.emresahin.saymyname.characters.charactersScreen
import com.emresahin.saymyname.quotes.navigateToQuotesScreen
import com.emresahin.saymyname.quotes.quotesScreen

const val rootGraphRoute = "root"

@Composable
fun SayMyNameHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = charactersBaseRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        route = rootGraphRoute
    ) {
        charactersScreen(
            onNavigateBack = onBackClick,
            onNavigateToQuotes = navController::navigateToQuotesScreen,
            onNavigateToCharacterDetail = navController::navigateToCharacterDetailScreen
        )
        characterDetailScreen(onNavigateBack = onBackClick)
        quotesScreen(onNavigateBack = onBackClick, onNavigateToQuoteDetail = {})
    }
}