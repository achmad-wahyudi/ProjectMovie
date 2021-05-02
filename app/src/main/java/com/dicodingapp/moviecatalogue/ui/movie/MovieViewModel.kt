package com.dicodingapp.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.dicodingapp.moviecatalogue.data.MovieEntity
import com.dicodingapp.moviecatalogue.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovie()
}