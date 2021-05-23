package com.dicodingapp.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.dicodingapp.moviecatalogue.data.source.local.LocalDataSource
import com.dicodingapp.moviecatalogue.data.source.local.entity.*
import com.dicodingapp.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicodingapp.moviecatalogue.data.source.remote.network.ApiResponse
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.MovieDetailResponse
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.ResultsItem
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.ResultsItemTvShow
import com.dicodingapp.moviecatalogue.data.source.remote.network.response.TvShowDetailResponse
import com.dicodingapp.moviecatalogue.utils.AppExecutors
import com.dicodingapp.moviecatalogue.vo.Resource

class FilmRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    FilmDataSource {

    companion object {
        @Volatile
        private var instance: FilmRepository? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(remoteData, localData, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getAllMovie(): LiveData<Resource<List<MovieEntity>>> {
        return object :
            NetworkBoundResource<List<MovieEntity>, List<ResultsItem>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MovieEntity>> =
                localDataSource.getAllMovie()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ResultsItem>>> =
                remoteDataSource.getAllMovie()

            public override fun saveCallResult(data: List<ResultsItem>) {
                val movieList = java.util.ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.id.toString(),
                        response.title!!,
                        response.releaseDate!!,
                        "",
                        "",
                        response.voteAverage!!,
                        response.posterPath!!,
                        response.overview!!,
                        response.backdropPath!!,
                        0,
                        0,
                        response.popularity!!
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getMovieById(movieId: Int): LiveData<Resource<MovieWithGenreAndCast>> {
        return object :
            NetworkBoundResource<MovieWithGenreAndCast, MovieDetailResponse>(appExecutors) {
            public override fun loadFromDB(): LiveData<MovieWithGenreAndCast> =
                localDataSource.getMovieById(movieId.toString())

            override fun shouldFetch(data: MovieWithGenreAndCast?): Boolean =
                data == null || data.mMovie.status.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> =
                remoteDataSource.getMovieById(movieId)

            public override fun saveCallResult(data: MovieDetailResponse) {
                val genreList = java.util.ArrayList<GenresEntity>()
                for (genre in data.genres!!) {
                    val genreEntity = GenresEntity(
                        movieId.toString(),
                        genre?.id.toString(),
                        genre?.name!!
                    )
                    genreList.add(genreEntity)
                }
                val movie = MovieEntity(
                    data.id.toString(),
                    data.title!!,
                    data.releaseDate!!,
                    data.status!!,
                    data.tagline!!,
                    data.voteAverage!!,
                    data.posterPath!!,
                    data.overview!!,
                    data.backdropPath!!,
                    data.budget!!,
                    data.revenue!!,
                    data.popularity!!,
                )
                localDataSource.insertMovie(movie)
                localDataSource.insertGenres(genreList)
            }
        }.asLiveData()
    }

    override fun getAllTvShow(): LiveData<Resource<List<TvShowEntity>>> {
        return object :
            NetworkBoundResource<List<TvShowEntity>, List<ResultsItemTvShow>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<TvShowEntity>> =
                localDataSource.getAllTvShow()

            override fun shouldFetch(data: List<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ResultsItemTvShow>>> =
                remoteDataSource.getAllTvShow()

            public override fun saveCallResult(data: List<ResultsItemTvShow>) {
                val tvShowList = java.util.ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(
                        response.backdropPath!!,
                        response.firstAirDate!!,
                        response.id.toString(),
                        "",
                        response.name!!,
                        0,
                        0,
                        "",
                        response.posterPath!!,
                        "",
                        "",
                        "",
                        response.voteAverage!!,
                        response.popularity!!,
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun getTvShowById(tvShowId: Int): LiveData<Resource<TvShowWithGenreAndCastAndLastEpisode>> {
        return object :
            NetworkBoundResource<TvShowWithGenreAndCastAndLastEpisode, TvShowDetailResponse>(
                appExecutors
            ) {
            public override fun loadFromDB(): LiveData<TvShowWithGenreAndCastAndLastEpisode> =
                localDataSource.getTvShowById(tvShowId.toString())

            override fun shouldFetch(data: TvShowWithGenreAndCastAndLastEpisode?): Boolean =
                data == null || data.mTvShow.status.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<TvShowDetailResponse>> =
                remoteDataSource.getTvShowById(tvShowId)

            public override fun saveCallResult(data: TvShowDetailResponse) {
                val genreList = java.util.ArrayList<GenresTvShowEntity>()
                for (genre in data.genres!!) {
                    val genreEntity = GenresTvShowEntity(
                        tvShowId.toString(),
                        genre?.id.toString(),
                        genre?.name!!
                    )
                    genreList.add(genreEntity)
                }
                val lastEpisodeToAir = TvShowLastEpisodeEntity(
                    tvShowId.toString(),
                    data.lastEpisodeToAir?.airDate.toString(),
                    data.lastEpisodeToAir?.episodeNumber.toString(),
                    data.lastEpisodeToAir?.id.toString(),
                    data.lastEpisodeToAir?.name.toString(),
                    data.lastEpisodeToAir?.overview.toString(),
                    data.lastEpisodeToAir?.seasonNumber.toString(),
                    data.lastEpisodeToAir?.stillPath.toString(),
                )
                val tvShow = TvShowEntity(
                    data.backdropPath!!,
                    data.firstAirDate!!,
                    data.id.toString(),
                    data.lastAirDate!!,
                    data.name!!,
                    data.numberOfEpisodes!!,
                    data.numberOfSeasons!!,
                    data.overview!!,
                    data.posterPath!!,
                    data.status!!,
                    data.tagline!!,
                    data.type!!,
                    data.voteAverage!!,
                    data.popularity!!,
                )
                localDataSource.insertTvShow(tvShow)
                localDataSource.insertGenresTvShow(genreList)
                localDataSource.insertLastEpisodeToAir(lastEpisodeToAir)
            }
        }.asLiveData()
    }

    override fun getAllBookmarkedMovie(): LiveData<List<MovieEntity>> =
        localDataSource.getAllBookmarkedMovie()

    override fun setMovieBookmark(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieBookmark(movie, state) }

    override fun getAllBookmarkedTvShow(): LiveData<List<TvShowEntity>> =
        localDataSource.getAllBookmarkedTvShow()

    override fun setTvShowBookmark(tvShow: TvShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvShowBookmark(tvShow, state) }
}