package com.emresahin.saymyname.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.emresahin.saymyname.navigation.SayMyNameHost

@Composable
fun rememberSayMyNameAppState(
    navController: NavHostController = rememberNavController(),
): SayMyNameAppState {
    return remember(navController) {
        SayMyNameAppState(navController)
    }
}

@Composable
fun SayMyNameApp(
    appState: SayMyNameAppState = rememberSayMyNameAppState(),
) {
    Scaffold(modifier = Modifier) { innerPaddings ->
        SayMyNameHost(
            modifier = Modifier.padding(innerPaddings),
            navController = appState.navController,
            onBackClick = appState::onBackClick
        )
    }
}