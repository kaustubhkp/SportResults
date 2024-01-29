package com.sport.results.app.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sport.results.app.presentation.home.HomeScreen
import com.sport.results.app.presentation.viewmodels.AppViewModel
import com.sport.results.app.presentation.sports.SportsScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
) {
    val viewModel : AppViewModel = viewModel()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "baseapp"
    ) {
        navigation(
            startDestination = startDestination,
            route = "baseapp"
        ){
            composable(NavigationItem.Home.route) {
                HomeScreen(navController , viewModel)
            }
            composable(
                NavigationItem.Sports.route ,
            ) {
                SportsScreen(viewModel = viewModel )
            }
        }
    }
}