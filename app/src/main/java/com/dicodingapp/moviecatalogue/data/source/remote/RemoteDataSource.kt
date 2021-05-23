package com.dicodingapp.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicodingapp.moviecatalogue.data.source.remote.network.ApiResponse
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

    fun getAllMovie(): LiveData<ApiResponse<List<ResultsItem>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<ResultsItem>>>()
        handler.postDelayed(
            {
                apiService.getPopularMovies(page = 1).enqueue(
                    object : Callback<MoviesResponse> {
                        override fun onFailure(call: Call<MoviesResponse>?, t: Throwable) {
                            resultMovie.value = ApiResponse.error(t.message.toString(), emptyList())
                        }

                        override fun onResponse(
                            call: Call<MoviesResponse>?,
                            response: Response<MoviesResponse>
                        ) {
                            if (response.isSuccessful) {
                                val data = response.body()?.results ?: emptyList()
                                resultMovie.value = ApiResponse.success(data)
                            } else {
                                resultMovie.value = ApiResponse.success(emptyList())
                            }
                        }
                    }
                )

                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
        return resultMovie
    }

    fun getMovieById(movieId: Int): LiveData<ApiResponse<MovieDetailResponse>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<MovieDetailResponse>>()
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
                                resultMovie.value = ApiResponse.success(data as MovieDetailResponse)
                            }
                        }
                    }
                )

                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
        return resultMovie
    }

    fun getAllTvShow(): LiveData<ApiResponse<List<ResultsItemTvShow>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<ResultsItemTvShow>>>()
        handler.postDelayed(
            {
                apiService.getPopularTvShow(page = 1).enqueue(
                    object : Callback<TvShowsResponse> {
                        override fun onFailure(call: Call<TvShowsResponse>?, t: Throwable) {
                            resultTvShow.value =
                                ApiResponse.error(t.message.toString(), emptyList())
                        }

                        override fun onResponse(
                            call: Call<TvShowsResponse>?,
                            response: Response<TvShowsResponse>
                        ) {
                            if (response.isSuccessful) {
                                val data = response.body()?.results ?: emptyList()
                                resultTvShow.value = ApiResponse.success(data)
                            } else {
                                resultTvShow.value = ApiResponse.success(emptyList())
                            }
                        }
                    }
                )

                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
        return resultTvShow
    }

    fun getTvShowById(tvShowId: Int): LiveData<ApiResponse<TvShowDetailResponse>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<TvShowDetailResponse>>()
        handler.postDelayed(
            {
                apiService.getTvShowById(id = tvShowId.toString()).enqueue(
                    object : Callback<TvShowDetailResponse> {
                        override fun onFailure(call: Call<TvShowDetailResponse>?, t: Throwable) {
                        }

                        override fun onResponse(
                            call: Call<TvShowDetailResponse>?,
                            response: Response<TvShowDetailResponse>
                        ) {
                            if (response.isSuccessful) {
                                val data = response.body() ?: emptyArray<TvShowDetailResponse>()
                                resultTvShow.value =
                                    ApiResponse.success(data as TvShowDetailResponse)
                            }
                        }
                    }
                )

                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
        return resultTvShow
    }
}