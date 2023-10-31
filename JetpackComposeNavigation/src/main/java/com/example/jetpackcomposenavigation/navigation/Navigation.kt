package com.example.jetpackcomposenavigation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposenavigation.screens.DetailScreen
import com.example.jetpackcomposenavigation.screens.MainScreen
import com.example.jetpackcomposenavigation.utils.ScreenRoute

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoute.MainScreen.name) {
        composable(ScreenRoute.MainScreen.name) {
            MainScreen(navController)
        }
        composable(
            "${ScreenRoute.DetailScreen.name}/{name}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                }
            ),
        ) { entry ->
            DetailScreen(name = entry.arguments?.getString("name", ""))
        }
    }
}