package com.dicodingapp.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import com.dicodingapp.moviecatalogue.data.source.remote.network.ApiService
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.*
import com.dicodingapp.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 1000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service).apply { instance = this }
            }
    }

    fun getAllMovie(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                apiService.getPopularMovies(page = 1).enqueue(
                    object : Callback<MoviesResponse> {
                        override fun onFailure(call: Call<MoviesResponse>?, t: Throwable) {
                            callback.onAllMovieReceived(emptyList())
                        }

                        override fun onResponse(
                            call: Call<MoviesResponse>?,
                            response: Response<MoviesResponse>
                        ) {
                            if (response.isSuccessful) {
                                val data = response.body()?.results ?: emptyList()
                                callback.onAllMovieReceived(data)
                            } else {
                                callback.onAllMovieReceived(emptyList())
                            }
                        }
                    }
                )

                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getMovieById(movieId: Int, callback: LoadMovieByIdCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                apiService.getMovieById(id = movieId.toString()).enqueue(
                    object : Callback<MovieDetailResponse> {
                        override fun onFailure(call: Call<MovieDetailResponse>?, t: Throwable) {
                        }

                        override fun onResponse(
                            call: Call<MovieDetailResponse>?,
                            response: Response<MovieDetailResponse>
                        ) {
                            if (response.isSuccessful) {
                                val data = response.body() ?: emptyArray<MovieDetailResponse>()
                                callback.onMovieByIdReceived(data as MovieDetailResponse)
                            }
                        }
                    }
                )

                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getAllTvShow(callback: LoadTvShowsCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                apiService.getPopularTvShow(page = 1).enqueue(
                    object : Callback<TvShowsResponse> {
                        override fun onFailure(call: Call<TvShowsResponse>?, t: Throwable) {
                            callback.onAllTvShowReceived(emptyList())
                        }

                        override fun onResponse(
                            call: Call<TvShowsResponse>?,
                            response: Response<TvShowsResponse>
                        ) {
                            if (response.isSuccessful) {
                                val data = response.body()?.results ?: emptyList()
                                callback.onAllTvShowReceived(data)
                            } else {
                                callback.onAllTvShowReceived(emptyList())
                            }
                        }
                    }
                )

                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getTvShowById(movieId: Int, callback: LoadTvShowByIdCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                apiService.getTvShowById(id = movieId.toString()).enqueue(
                    object : Callback<TvShowDetailResponse> {
                        override fun onFailure(call: Call<TvShowDetailResponse>?, t: Throwable) {
                        }

                        override fun onResponse(
                            call: Call<TvShowDetailResponse>?,
                            response: Response<TvShowDetailResponse>
                        ) {
                            if (response.isSuccessful) {
                                val data = response.body() ?: emptyArray<TvShowDetailResponse>()
                                callback.onTvShowByIdReceived(data as TvShowDetailResponse)
                            }
                        }
                    }
                )

                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    interface LoadMoviesCallback {
        fun onAllMovieReceived(itemMovieResponse: List<ResultsItem?>)
    }

    interface LoadMovieByIdCallback {
        fun onMovieByIdReceived(movieDetailResponse: MovieDetailResponse)
    }

    interface LoadTvShowsCallback {
        fun onAllTvShowReceived(itemTvShowResponse: List<ResultsItemTvShow?>)
    }

    interface LoadTvShowByIdCallback {
        fun onTvShowByIdReceived(tvShowDetailResponse: TvShowDetailResponse)
    }
}