package com.dicodingapp.moviecatalogue.ui.movie

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.dicodingapp.moviecatalogue.data.MovieEntity
import com.dicodingapp.moviecatalogue.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovies(activity: Activity): List<MovieEntity> = DataDummy.generateDummyMovie(activity)
}