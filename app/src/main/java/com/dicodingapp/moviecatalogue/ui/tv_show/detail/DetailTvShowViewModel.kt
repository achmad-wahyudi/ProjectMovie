package com.dicodingapp.moviecatalogue.ui.tv_show.detail

import androidx.lifecycle.ViewModel
import com.dicodingapp.moviecatalogue.data.TvShowEntity
import com.dicodingapp.moviecatalogue.utils.DataDummy

class DetailTvShowViewModel : ViewModel() {
    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvShowEntity {
        lateinit var tvShow: TvShowEntity
        val tvShowsEntities = DataDummy.generateDummyTvShow()
        for (tvShowEntity in tvShowsEntities) {
            if (tvShowEntity.tvShowId == tvShowId) {
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }

}