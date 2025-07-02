package com.example.movieplayer.screens

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable("home_screen") {
            HomeScreen(onVideoClick = { encodedUrl ->
                navController.navigate("player_screen/$encodedUrl")
            })
        }

        composable("player_screen/{videoUrl}") { backStackEntry ->
            val videoUrl = backStackEntry.arguments?.getString("videoUrl")?.let { Uri.decode(it) } ?: ""
            PlayerScreen(videoUrl = videoUrl, navController = navController)
        }
    }
}
