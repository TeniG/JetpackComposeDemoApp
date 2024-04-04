package com.example.jetpackcomposelazycolumn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposelazycolumn.domain.models.TvShow
import com.example.jetpackcomposelazycolumn.presentation.TvShowDetail
import com.example.jetpackcomposelazycolumn.presentation.TvShowListScreen
import com.example.jetpackcomposelazycolumn.presentation.utils.Screen
import com.google.gson.Gson

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.TvShowListScreen.route) {
        composable(route = Screen.TvShowListScreen.route) {
            TvShowListScreen(navController = navController)
        }
        composable(route = Screen.TvShowDetailScreen.route
        ) {
             TvShowDetail( navController = navController )
        }
    }
}