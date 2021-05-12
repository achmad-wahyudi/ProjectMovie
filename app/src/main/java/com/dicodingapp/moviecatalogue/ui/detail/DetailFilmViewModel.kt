package com.dicodingapp.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicodingapp.moviecatalogue.data.MovieEntity
import com.dicodingapp.moviecatalogue.data.TvShowEntity
import com.dicodingapp.moviecatalogue.data.source.FilmRepository

class DetailFilmViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovie(movieId: String): LiveData<MovieEntity> = filmRepository.getMovieById(Integer.parseInt(movieId))

    fun getTvShow(tvShowId: String): LiveData<TvShowEntity> =
        filmRepository.getTvShowById(Integer.parseInt(tvShowId))
}