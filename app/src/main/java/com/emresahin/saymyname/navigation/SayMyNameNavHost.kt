package com.emresahin.saymyname.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.emresahin.saymyname.characters.charactersBaseRoute
import com.emresahin.saymyname.characters.charactersScreen

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
        charactersScreen(onNavigateBack = onBackClick)
    }
}