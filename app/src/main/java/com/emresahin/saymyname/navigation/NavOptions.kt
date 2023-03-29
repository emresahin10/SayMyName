package com.emresahin.saymyname.navigation

import androidx.navigation.NavOptions

object SayMyNameNavOptions {
    val popUpToRootThenNavigate: NavOptions
        get() = NavOptions.Builder()
            .setPopUpTo(
                route = rootGraphRoute,
                inclusive = false,
                saveState = false,
            ).build()
}