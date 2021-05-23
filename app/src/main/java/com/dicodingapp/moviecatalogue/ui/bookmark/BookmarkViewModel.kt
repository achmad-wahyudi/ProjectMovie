package com.dicodingapp.moviecatalogue.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicodingapp.moviecatalogue.data.FilmRepository
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowEntity

class BookmarkViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovies(): LiveData<PagedList<MovieEntity>> = filmRepository.getAllBookmarkedMovie()

    fun getTvShow(): LiveData<PagedList<TvShowEntity>> = filmRepository.getAllBookmarkedTvShow()
}