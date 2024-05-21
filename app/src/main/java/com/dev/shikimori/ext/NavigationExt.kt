package com.dev.shikimori.ext

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController

val NavHostController.canGoBack: Boolean
    get() = currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED

fun NavHostController.navigateBack() {
    if (canGoBack) {
        popBackStack()
    }
}