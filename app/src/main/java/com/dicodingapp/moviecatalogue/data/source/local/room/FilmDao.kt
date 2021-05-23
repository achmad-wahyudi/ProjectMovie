package com.dicodingapp.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dicodingapp.moviecatalogue.data.source.local.entity.*

@Dao
interface FilmDao {

    @Query("SELECT * FROM moviesentities ORDER BY popularity DESC")
    fun getAllMovie(): DataSource.Factory<Int, MovieEntity>

    @Transaction
    @Query("SELECT * FROM moviesentities WHERE movieId = :movieId")
    fun getMovieById(movieId: String): LiveData<MovieWithGenreAndCast>

    @Query("SELECT * FROM tvshowsentities ORDER BY popularity DESC")
    fun getAllTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Transaction
    @Query("SELECT * FROM tvshowsentities WHERE tvShowId = :tvShowId")
    fun getTvShowById(tvShowId: String): LiveData<TvShowWithGenreAndCastAndLastEpisode>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: TvShowEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenres(genres: List<GenresEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenresTvShow(genres: List<GenresTvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLastEpisodeToAir(lastEpisodeToAir: TvShowLastEpisodeEntity)

    @Query("SELECT * FROM moviesentities where bookmarked = 1")
    fun getBookmarkedMovie(): DataSource.Factory<Int, MovieEntity>

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("SELECT * FROM tvshowsentities where bookmarked = 1")
    fun getBookmarkedTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Update
    fun updateTvShow(movie: TvShowEntity)
}