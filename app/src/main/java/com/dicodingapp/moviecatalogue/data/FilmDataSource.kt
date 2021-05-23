package com.dicodingapp.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieWithGenreAndCast
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowWithGenreAndCastAndLastEpisode
import com.dicodingapp.moviecatalogue.vo.Resource

interface FilmDataSource {
    fun getAllMovie(): LiveData<Resource<List<MovieEntity>>>

    fun getMovieById(movieId: Int): LiveData<Resource<MovieWithGenreAndCast>>

    fun getAllTvShow(): LiveData<Resource<List<TvShowEntity>>>

    fun getTvShowById(tvShowId: Int): LiveData<Resource<TvShowWithGenreAndCastAndLastEpisode>>

    fun getAllBookmarkedMovie(): LiveData<List<MovieEntity>>

    fun setMovieBookmark(movie: MovieEntity, state: Boolean)

    fun getAllBookmarkedTvShow(): LiveData<List<TvShowEntity>>

    fun setTvShowBookmark(tvShow: TvShowEntity, state: Boolean)
}