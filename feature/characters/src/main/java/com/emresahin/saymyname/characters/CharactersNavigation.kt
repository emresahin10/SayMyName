package com.emresahin.saymyname.characters

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val charactersBaseRoute = "characters"

fun NavGraphBuilder.charactersScreen(
    onNavigateBack: () -> Unit,
    onNavigateToQuotes: () -> Unit,
    onNavigateToCharacterDetail: (characterId: String) -> Unit,
) = composable(
    route = charactersBaseRoute,
) {
    val viewModel: CharactersViewModel = hiltViewModel()
    val state by viewModel.viewState.collectAsState()
    CharactersScreen(
        state = state,
        onNavigateBack = onNavigateBack,
        onNavigateToQuotes = onNavigateToQuotes,
        onNavigateToCharacterDetail = onNavigateToCharacterDetail,
    )
}

fun NavController.navigateToCharactersScreen(options: NavOptions) {
    this.navigate(route = charactersBaseRoute, navOptions = options)
}