package com.example.movieplayer.screens

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieplayer.viewmodel.VideoViewModel

@Composable
fun HomeScreen(
    onVideoClick: (String) -> Unit,
    viewModel: VideoViewModel = viewModel()
) {
    val videoList by viewModel.videoList.collectAsState()

    LaunchedEffect(videoList) {
        Log.d("HomeScreen", "Video list received: size = ${videoList.size}")
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        if (videoList.isEmpty()) {
            Text(
                text = "No videos found. Check your internet or API.",
                color = Color.White
            )
            return
        }

        val chunkedList = videoList.chunked(3)

        chunkedList.forEach { rowVideos ->
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                items(rowVideos) { video ->
                    VideoCard(
                        video = video,
                        onClick = {
                            val videoUrl = video.video_files.firstOrNull()?.link ?: ""
                            val encodedUrl = Uri.encode(videoUrl)
                            Log.d("HomeScreen", "Navigating to: $encodedUrl")
                            onVideoClick(encodedUrl)
                        }
                    )
                }
            }
        }
    }
}
