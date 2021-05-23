package com.dicodingapp.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicodingapp.moviecatalogue.data.source.local.entity.*
import com.dicodingapp.moviecatalogue.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao)
    }

    fun getAllMovie(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getAllMovie()

    fun getMovieById(movieId: String): LiveData<MovieWithGenreAndCast> =
        mFilmDao.getMovieById(movieId)

    fun getAllTvShow(): DataSource.Factory<Int, TvShowEntity> = mFilmDao.getAllTvShow()

    fun getTvShowById(tvShowId: String): LiveData<TvShowWithGenreAndCastAndLastEpisode> =
        mFilmDao.getTvShowById(tvShowId)

    fun insertMovies(movies: List<MovieEntity>) = mFilmDao.insertMovies(movies)

    fun insertMovie(movie: MovieEntity) {
        mFilmDao.insertMovie(movie)
    }

    fun insertTvShows(tvShows: List<TvShowEntity>) = mFilmDao.insertTvShows(tvShows)

    fun insertTvShow(tvShow: TvShowEntity) {
        mFilmDao.insertTvShow(tvShow)
    }

    fun insertGenres(genres: List<GenresEntity>) = mFilmDao.insertGenres(genres)

    fun insertGenresTvShow(genres: List<GenresTvShowEntity>) = mFilmDao.insertGenresTvShow(genres)

    fun insertLastEpisodeToAir(lastEpisodeToAir: TvShowLastEpisodeEntity) =
        mFilmDao.insertLastEpisodeToAir(lastEpisodeToAir)

    fun getAllBookmarkedMovie(): DataSource.Factory<Int, MovieEntity> =
        mFilmDao.getBookmarkedMovie()

    fun setMovieBookmark(movie: MovieEntity, newState: Boolean) {
        movie.bookmarked = newState
        mFilmDao.updateMovie(movie)
    }

    fun getAllBookmarkedTvShow(): DataSource.Factory<Int, TvShowEntity> =
        mFilmDao.getBookmarkedTvShow()

    fun setTvShowBookmark(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.bookmarked = newState
        mFilmDao.updateTvShow(tvShow)
    }

}