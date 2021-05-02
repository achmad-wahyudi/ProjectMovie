package com.dicodingapp.moviecatalogue.ui.tv_show

import androidx.lifecycle.ViewModel
import com.dicodingapp.moviecatalogue.data.TvShowEntity
import com.dicodingapp.moviecatalogue.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShow()
}