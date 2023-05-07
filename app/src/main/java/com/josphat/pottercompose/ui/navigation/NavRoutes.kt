package com.josphat.pottercompose.ui.navigation


sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("Home_screen")
    object Details: NavRoutes("Detail_screen")
}
