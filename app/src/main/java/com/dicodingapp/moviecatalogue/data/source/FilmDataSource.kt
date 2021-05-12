package com.dicodingapp.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.dicodingapp.moviecatalogue.data.MovieEntity
import com.dicodingapp.moviecatalogue.data.TvShowEntity

interface FilmDataSource {
    fun getAllMovie(): LiveData<List<MovieEntity>>

    fun getMovieById(movieId: Int): LiveData<MovieEntity>

    fun getAllTvShow(): LiveData<List<TvShowEntity>>

    fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity>
}