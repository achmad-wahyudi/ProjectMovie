package com.dicodingapp.moviecatalogue.ui.tv_show.detail

import com.dicodingapp.moviecatalogue.ui.detail.DetailFilmViewModel
import com.dicodingapp.moviecatalogue.utils.DataDummy
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailFilmViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel()
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dummyTvShow.tvShowId)
        val tvShowEntity = viewModel.getTvShow()
        TestCase.assertNotNull(tvShowEntity)
        TestCase.assertEquals(dummyTvShow.tvShowId, tvShowEntity.tvShowId)
        TestCase.assertEquals(dummyTvShow.name, tvShowEntity.name)
        TestCase.assertEquals(dummyTvShow.firstAirDate, tvShowEntity.firstAirDate)
        TestCase.assertEquals(dummyTvShow.status, tvShowEntity.status)
        TestCase.assertEquals(dummyTvShow.tagLine, tvShowEntity.tagLine)
        TestCase.assertEquals(dummyTvShow.voteAverage, tvShowEntity.voteAverage)
        TestCase.assertEquals(dummyTvShow.posterPath, tvShowEntity.posterPath)
        TestCase.assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        TestCase.assertEquals(dummyTvShow.backdropPath, tvShowEntity.backdropPath)
        TestCase.assertEquals(dummyTvShow.numberOfEpisodes, tvShowEntity.numberOfEpisodes)
        TestCase.assertEquals(dummyTvShow.numberOfSeasons, tvShowEntity.numberOfSeasons)

        val genresEntities = viewModel.getTvShow().genres
        TestCase.assertNotNull(genresEntities)
        TestCase.assertEquals(4, genresEntities.size.toLong())

        val castsEntities = viewModel.getTvShow().casts
        TestCase.assertNotNull(castsEntities)
        TestCase.assertEquals(3, castsEntities.size.toLong())
    }
}