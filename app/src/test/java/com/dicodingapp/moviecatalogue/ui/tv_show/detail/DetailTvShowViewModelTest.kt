package com.dicodingapp.moviecatalogue.ui.tv_show.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicodingapp.moviecatalogue.data.TvShowEntity
import com.dicodingapp.moviecatalogue.data.source.FilmRepository
import com.dicodingapp.moviecatalogue.ui.detail.DetailFilmViewModel
import com.dicodingapp.moviecatalogue.utils.DataDummy
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailFilmViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel(filmRepository)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        Mockito.`when`(filmRepository.getTvShowById(Integer.parseInt(tvShowId))).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShow(tvShowId).value
        Mockito.verify(filmRepository).getTvShowById(Integer.parseInt(tvShowId))
        TestCase.assertNotNull(tvShowEntities)
        TestCase.assertEquals(dummyTvShow.tvShowId, tvShowEntities!!.tvShowId)
        TestCase.assertEquals(dummyTvShow.name, tvShowEntities.name)
        TestCase.assertEquals(dummyTvShow.firstAirDate, tvShowEntities.firstAirDate)
        TestCase.assertEquals(dummyTvShow.status, tvShowEntities.status)
        TestCase.assertEquals(dummyTvShow.tagLine, tvShowEntities.tagLine)
        TestCase.assertEquals(dummyTvShow.voteAverage, tvShowEntities.voteAverage)
        TestCase.assertEquals(dummyTvShow.posterPath, tvShowEntities.posterPath)
        TestCase.assertEquals(dummyTvShow.overview, tvShowEntities.overview)
        TestCase.assertEquals(dummyTvShow.backdropPath, tvShowEntities.backdropPath)
        TestCase.assertEquals(dummyTvShow.numberOfEpisodes, tvShowEntities.numberOfEpisodes)
        TestCase.assertEquals(dummyTvShow.numberOfSeasons, tvShowEntities.numberOfSeasons)

        val genresEntities = tvShowEntities.genres
        TestCase.assertNotNull(genresEntities)
        TestCase.assertEquals(4, genresEntities.size.toLong())

        viewModel.getTvShow(tvShowId).observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)
    }
}