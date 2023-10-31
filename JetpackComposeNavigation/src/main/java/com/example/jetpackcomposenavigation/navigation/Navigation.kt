package com.example.jetpackcomposenavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposenavigation.screens.DetailScreen
import com.example.jetpackcomposenavigation.screens.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") {
            MainScreen(navController)
        }
        composable(
            "detail_screen/{name}",
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