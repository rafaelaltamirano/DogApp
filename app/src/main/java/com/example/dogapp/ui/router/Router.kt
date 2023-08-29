package com.example.dogapp.ui.router

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dogapp.ui.main.MainViewModel
import com.example.dogapp.ui.screens.home.HomeScreen
import com.example.dogapp.ui.screens.home.HomeViewModel

@Composable
fun Router(mainModel: MainViewModel) {

    val navController = rememberNavController()
    val homeModel = hiltViewModel<HomeViewModel>()


    NavHost(
        navController = navController,
        startDestination = if (mainModel.state.loading) RouterDir.SPLASH.route else RouterDir.HOME.route,
    ) {
        composable(RouterDir.HOME.route) {
            HomeScreen(homeModel = homeModel)
        }
    }
}