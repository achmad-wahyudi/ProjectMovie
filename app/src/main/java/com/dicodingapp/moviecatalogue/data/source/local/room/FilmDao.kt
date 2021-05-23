package com.dicodingapp.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dicodingapp.moviecatalogue.data.source.local.entity.*

@Dao
interface FilmDao {

    @Query("SELECT * FROM moviesentities")
    fun getAllMovie(): LiveData<List<MovieEntity>>

    @Transaction
    @Query("SELECT * FROM moviesentities WHERE movieId = :movieId")
    fun getMovieById(movieId: String): LiveData<MovieWithGenreAndCast>

    @Query("SELECT * FROM tvshowsentities")
    fun getAllTvShow(): LiveData<List<TvShowEntity>>

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
}