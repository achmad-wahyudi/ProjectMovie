package com.dicodingapp.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicodingapp.moviecatalogue.data.source.FilmDataSource
import com.dicodingapp.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.MovieDetailResponse
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.ResultsItem
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.ResultsItemTvShow
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.TvShowDetailResponse

class FakeFilmRepository(private val remoteDataSource: RemoteDataSource) :
    FilmDataSource {

    override fun getAllMovie(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMovieReceived(itemMovieResponse: List<ResultsItem?>) {
                val movieList = java.util.ArrayList<MovieEntity>()
                for (response in itemMovieResponse) {
                    val movie = MovieEntity(
                        emptyList(),
                        response?.id.toString(),
                        response?.title!!,
                        response.releaseDate!!,
                        "",
                        "",
                        response.voteAverage!!,
                        response.posterPath!!,
                        response.overview!!,
                        response.backdropPath!!,
                        emptyList(),
                        0,
                        0,
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })

        return movieResults
    }

    override fun getMovieById(movieId: Int): LiveData<MovieEntity> {
        val movieResult = MutableLiveData<MovieEntity>()
        remoteDataSource.getMovieById(movieId, object : RemoteDataSource.LoadMovieByIdCallback {
            override fun onMovieByIdReceived(movieDetailResponse: MovieDetailResponse) {
                val genreList = java.util.ArrayList<GenresEntity>()
                for (genre in movieDetailResponse.genres!!) {
                    val genreEntity = GenresEntity(
                        genre?.id.toString(),
                        genre?.name!!
                    )
                    genreList.add(genreEntity)
                }
                val movie = MovieEntity(
                    genreList,
                    movieDetailResponse.id.toString(),
                    movieDetailResponse.title!!,
                    movieDetailResponse.releaseDate!!,
                    movieDetailResponse.status!!,
                    movieDetailResponse.tagline!!,
                    movieDetailResponse.voteAverage!!,
                    movieDetailResponse.posterPath!!,
                    movieDetailResponse.overview!!,
                    movieDetailResponse.backdropPath!!,
                    emptyList(),
                    movieDetailResponse.budget!!,
                    movieDetailResponse.revenue!!,
                )
                movieResult.postValue(movie)
            }
        })

        return movieResult
    }

    override fun getAllTvShow(): LiveData<List<TvShowEntity>> {
        val tvShowResults = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowReceived(itemTvShowResponse: List<ResultsItemTvShow?>) {
                val tvShowList = java.util.ArrayList<TvShowEntity>()
                for (response in itemTvShowResponse) {
                    val tvShow = TvShowEntity(
                        response?.backdropPath!!,
                        response.firstAirDate!!,
                        emptyList(),
                        response.id.toString(),
                        "",
                        null,
                        response.name!!,
                        0,
                        0,
                        "",
                        response.posterPath!!,
                        "",
                        "",
                        "",
                        response.voteAverage!!,
                        emptyList(),
                    )
                    tvShowList.add(tvShow)
                }
                tvShowResults.postValue(tvShowList)
            }
        })

        return tvShowResults
    }

    override fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity> {
        val tvShowResult = MutableLiveData<TvShowEntity>()
        remoteDataSource.getTvShowById(tvShowId, object : RemoteDataSource.LoadTvShowByIdCallback {
            override fun onTvShowByIdReceived(tvShowDetailResponse: TvShowDetailResponse) {
                val genreList = java.util.ArrayList<GenresEntity>()
                for (genre in tvShowDetailResponse.genres!!) {
                    val genreEntity = GenresEntity(
                        genre?.id.toString(),
                        genre?.name!!
                    )
                    genreList.add(genreEntity)
                }
                val lastEpisodeToAir = TvShowLastEpisodeEntity(
                    tvShowDetailResponse.lastEpisodeToAir?.airDate.toString(),
                    tvShowDetailResponse.lastEpisodeToAir?.episodeNumber.toString(),
                    tvShowDetailResponse.lastEpisodeToAir?.id.toString(),
                    tvShowDetailResponse.lastEpisodeToAir?.name.toString(),
                    tvShowDetailResponse.lastEpisodeToAir?.overview.toString(),
                    tvShowDetailResponse.lastEpisodeToAir?.seasonNumber.toString(),
                    tvShowDetailResponse.lastEpisodeToAir?.stillPath.toString(),
                )
                val tvShow = TvShowEntity(
                    tvShowDetailResponse.backdropPath!!,
                    tvShowDetailResponse.firstAirDate!!,
                    genreList,
                    tvShowDetailResponse.id.toString(),
                    tvShowDetailResponse.lastAirDate!!,
                    lastEpisodeToAir,
                    tvShowDetailResponse.name!!,
                    tvShowDetailResponse.numberOfEpisodes!!,
                    tvShowDetailResponse.numberOfSeasons!!,
                    tvShowDetailResponse.overview!!,
                    tvShowDetailResponse.posterPath!!,
                    tvShowDetailResponse.status!!,
                    tvShowDetailResponse.tagline!!,
                    tvShowDetailResponse.type!!,
                    tvShowDetailResponse.voteAverage!!,
                    emptyList(),
                )
                tvShowResult.postValue(tvShow)
            }
        })

        return tvShowResult
    }
}