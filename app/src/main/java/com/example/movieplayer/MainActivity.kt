package com.example.movieplayer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.movieplayer.screens.AppNavigation
import com.example.movieplayer.ui.theme.MoviePlayerTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MainActivity", "App launched - onCreate called")

        setContent {
            val navController = rememberNavController()
            Log.d("MainActivity", "NavController initialized")

            MoviePlayerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    Log.d("MainActivity", "Setting AppNavigation content")
                    AppNavigation(navController = navController)
                }
            }
        }
    }
}
