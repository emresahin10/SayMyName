package com.emresahin.saymyname.character_detail

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val characterDetailBaseRoute = "characterDetail"
const val charactersBaseRoute = "characters"
const val charIdParam = "charId"

private fun characterDetailRoute(): String {
    return "$charactersBaseRoute/{$charIdParam}"
}

fun characterDetailRoute(charId: String): String {
    return "$charactersBaseRoute/$charId"
}

internal class CharacterDetailArgs(val charId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        charId = checkNotNull(savedStateHandle[charIdParam]) as String,
    )
}

fun NavGraphBuilder.characterDetailScreen(
    onNavigateBack: () -> Unit,
) = composable(
    route = characterDetailRoute(),
    arguments = listOf(
        navArgument(charIdParam) {
            type = NavType.StringType
        }
    ),
) {
    val viewModel: CharacterDetailViewModel = hiltViewModel()
    val state by viewModel.viewState.collectAsState()
    CharacterDetailScreen(
        state = state,
        onNavigateBack = onNavigateBack,
    )
}

fun NavController.navigateToCharacterDetailScreen(charId: String) {
    this.navigate(route = characterDetailRoute(charId))
}