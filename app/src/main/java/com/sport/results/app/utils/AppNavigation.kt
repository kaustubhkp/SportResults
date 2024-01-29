package com.sport.results.app.utils

enum class Screen {
    HOME,
    SPORTS
}
sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)
    data object Sports : NavigationItem(Screen.SPORTS.name)
}