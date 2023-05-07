package com.josphat.pottercompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController



@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoutes.Home.route) {
        Home(navController)
    }
    composable(NavRoutes.Details.route + "/{id}") {
        Details(
            onBackPressed = {
                navController.popBackStack()
            }
        )
    }

}