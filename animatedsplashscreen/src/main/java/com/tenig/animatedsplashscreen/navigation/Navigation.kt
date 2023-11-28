package com.tenig.animatedsplashscreen.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


import androidx.navigation.compose.rememberNavController
import com.tenig.animatedsplashscreen.MainScreen
import com.tenig.animatedsplashscreen.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

   NavHost(navController = navController, startDestination = "splash-screen") {
       composable("splash-screen") {
           SplashScreen(navController)
       }
       composable("main-screen") {
           MainScreen()
       }
   }
}