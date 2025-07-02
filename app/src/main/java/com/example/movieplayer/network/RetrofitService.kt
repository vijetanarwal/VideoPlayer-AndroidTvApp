package com.example.movieplayer.network

import com.example.movieplayer.model.PexelsResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitService {

    @Headers(
        "Authorization: 03hgobJcIBRSFuOlVKBRnJwFsXGwQIgp8CCnPyKHMGIBvPAInES01r2Q"
    )
    @GET("videos/popular")
    suspend fun getPopularVideos(
        @Query("per_page") perPage: Int = 20
    ): PexelsResponse
}
