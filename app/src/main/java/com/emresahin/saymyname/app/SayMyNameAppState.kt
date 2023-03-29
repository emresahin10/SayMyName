package com.emresahin.saymyname.app

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.core.net.toUri
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.emresahin.saymyname.common.extension.openUrl

@Stable
data class SayMyNameAppState(val navController: NavHostController) {

    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination


    fun onBackClick() {
        navController.popBackStack()
    }

    fun handleAction(action: String?) {
        if (action == null) return
        try {
            navController.navigate(action.toUri())
        } catch (exception: Exception) {
            kotlin.runCatching {
                navController.context.openUrl(action)
            }
        }
    }

    fun safeNavigateWithPopAll(route: String) = try {
        navController.navigate(route) {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
        }
    } catch (e: Exception) {
        e.localizedMessage?.let { Log.e(e.message, it) }
    }
}