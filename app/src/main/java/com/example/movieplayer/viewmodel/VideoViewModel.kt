package com.example.movieplayer.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieplayer.model.VideoItem
import com.example.movieplayer.repository.VideoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VideoViewModel : ViewModel() {

    private val repository = VideoRepository()

    private val _videoList = MutableStateFlow<List<VideoItem>>(emptyList())
    val videoList: StateFlow<List<VideoItem>> = _videoList

    init {
        fetchVideos()
    }

    private fun fetchVideos() {
        viewModelScope.launch {
            try {
                Log.d("VideoViewModel", "Fetching videos from repository...")
                val videos = repository.getVideos()
                _videoList.value = videos
                Log.d("VideoViewModel", "Fetched ${videos.size} videos")
            } catch (e: Exception) {
                Log.e("VideoViewModel", "Error fetching videos", e)
            }
        }
    }
}
