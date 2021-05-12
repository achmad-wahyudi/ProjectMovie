package com.dicodingapp.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicodingapp.moviecatalogue.data.MovieEntity
import com.dicodingapp.moviecatalogue.data.source.FilmRepository

class MovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovies(): LiveData<List<MovieEntity>> = filmRepository.getAllMovie()
}