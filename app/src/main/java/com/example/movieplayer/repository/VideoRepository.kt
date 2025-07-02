package com.example.movieplayer.repository

import android.util.Log
import com.example.movieplayer.model.VideoItem
import com.example.movieplayer.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideoRepository {

    suspend fun getVideos(): List<VideoItem> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d("VideoRepository", "Fetching videos from Pexels API...")
                val response = RetrofitClient.api.getPopularVideos()
                Log.d("VideoRepository", "Fetched ${response.videos.size} videos from API.")
                response.videos
            } catch (e: Exception) {
                Log.e("VideoRepository", "API Error: ${e.message}")
                emptyList()
            }
        }
    }
}
