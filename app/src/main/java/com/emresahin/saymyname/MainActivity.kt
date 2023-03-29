package com.emresahin.saymyname

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.core.net.toUri
import androidx.core.util.Consumer
import com.emresahin.saymyname.app.SayMyNameApp
import com.emresahin.saymyname.app.SayMyNameAppState
import com.emresahin.saymyname.app.rememberSayMyNameAppState
import com.emresahin.saymyname.ui.theme.SayMyNameTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = rememberSayMyNameAppState()

            LaunchedEffect(savedInstanceState) {
                if (savedInstanceState == null) {
                    appState.handleInitialRoute(intent)
                    appState.handleDeeplink(intent)
                }
            }

            DisposableEffect(Unit) {
                val listener = Consumer<Intent> { intent ->
                    appState.handleDeeplink(intent)
                }
                addOnNewIntentListener(listener)
                onDispose { removeOnNewIntentListener(listener) }
            }

            SayMyNameTheme {
                SayMyNameApp(appState)
            }
        }
    }

    private fun SayMyNameAppState.handleDeeplink(intent: Intent) {
        val deeplink = intent.getStringExtra(DEEPLINK_KEY)?.toUri()
        val updatedIntent = intent.apply {
            data = deeplink
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        navController.handleDeepLink(updatedIntent)
    }

    private fun SayMyNameAppState.handleInitialRoute(intent: Intent) {
        val route = intent.getStringExtra(INITIAL_NAVIGATION_ROUTE_KEY) ?: return
        safeNavigateWithPopAll(route)
    }

    companion object {
        const val INITIAL_NAVIGATION_ROUTE_KEY: String = "INITIAL_NAVIGATION_ROUTE_KEY"
        const val DEEPLINK_KEY: String = "DEEPLINK_KEY"
    }
}
