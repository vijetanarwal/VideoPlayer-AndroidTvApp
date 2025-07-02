package com.example.movieplayer.model

data class VideoFile(
    val id: Int,
    val quality: String,
    val file_type: String,
    val width: Int,
    val height: Int,
    val link: String
)

data class User(
    val id: Int,
    val name: String
)

data class VideoItem(
    val id: Int,
    val image: String,
    val duration: Int,
    val user: User,
    val video_files: List<VideoFile>
)

data class PexelsResponse(
    val page: Int,
    val per_page: Int,
    val total_results: Int,
    val videos: List<VideoItem>
)
