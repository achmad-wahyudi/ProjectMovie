package com.dicodingapp.moviecatalogue.data.source.remote.network

import com.dicodingapp.moviecatalogue.BuildConfig.API_KEY
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.MovieDetailResponse
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.MoviesResponse
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.TvShowDetailResponse
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.TvShowsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String? = API_KEY,
        @Query("page") page: Int = 0
    ): Call<MoviesResponse>

    @GET("movie/{id}")
    fun getMovieById(
        @Path("id") id: String,
        @Query("api_key") apiKey: String? = API_KEY
    ): Call<MovieDetailResponse>

    @GET("tv/popular")
    fun getPopularTvShow(
        @Query("api_key") apiKey: String? = API_KEY,
        @Query("page") page: Int = 0
    ): Call<TvShowsResponse>

    @GET("tv/{id}")
    fun getTvShowById(
        @Path("id") id: String,
        @Query("api_key") apiKey: String? = API_KEY
    ): Call<TvShowDetailResponse>

}