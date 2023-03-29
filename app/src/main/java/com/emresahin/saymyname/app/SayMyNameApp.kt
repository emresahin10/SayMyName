package com.emresahin.saymyname.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
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

@OptIn(ExperimentalMaterial3Api::class)
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