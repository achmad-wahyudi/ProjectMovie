package com.dicodingapp.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicodingapp.moviecatalogue.data.FilmRepository
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieWithGenreAndCast
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowWithGenreAndCastAndLastEpisode
import com.dicodingapp.moviecatalogue.vo.Resource

class DetailFilmViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovie(movieId: String): LiveData<Resource<MovieWithGenreAndCast>> =
        filmRepository.getMovieById(Integer.parseInt(movieId))

    fun getTvShow(tvShowId: String): LiveData<Resource<TvShowWithGenreAndCastAndLastEpisode>> =
        filmRepository.getTvShowById(Integer.parseInt(tvShowId))
}