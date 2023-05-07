package com.josphat.pottercompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.NavHost


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoutes.Home.route) {
        Home(navController)
    }
    composable(NavRoutes.Details.route + "/{id}") {
        Details(
            onBackPressed = {
                navController.popBacktack()
            }
        )
    }

}