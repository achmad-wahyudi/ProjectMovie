package com.dicodingapp.moviecatalogue.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicodingapp.moviecatalogue.data.FilmRepository
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowEntity

class BookmarkViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovies(): LiveData<List<MovieEntity>> = filmRepository.getAllBookmarkedMovie()

    fun getTvShow(): LiveData<List<TvShowEntity>> = filmRepository.getAllBookmarkedTvShow()
}