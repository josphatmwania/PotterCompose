package com.josphat.pottercompose.ui.navigation


sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("HomeScreen")
    object Details: NavRoutes("")
}
