package com.dicodingapp.moviecatalogue.ui.tv_show

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicodingapp.moviecatalogue.data.TvShowEntity
import com.dicodingapp.moviecatalogue.data.source.FilmRepository

class TvShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getTvShow(): LiveData<List<TvShowEntity>> = filmRepository.getAllTvShow()
}