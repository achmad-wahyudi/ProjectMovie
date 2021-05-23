package com.dicodingapp.moviecatalogue.ui.tv_show.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicodingapp.moviecatalogue.data.FilmRepository
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowWithGenreAndCastAndLastEpisode
import com.dicodingapp.moviecatalogue.ui.detail.DetailFilmViewModel
import com.dicodingapp.moviecatalogue.utils.DataDummy
import com.dicodingapp.moviecatalogue.vo.Resource
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
    private val dummyTvShowDetail =
        DataDummy.generateDummyTvShowWithGenreAndCastAndLastEpisode(dummyTvShow)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<TvShowWithGenreAndCastAndLastEpisode>>

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel(filmRepository)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<Resource<TvShowWithGenreAndCastAndLastEpisode>>()
        tvShow.value = Resource.success(dummyTvShowDetail)

        Mockito.`when`(filmRepository.getTvShowById(Integer.parseInt(tvShowId))).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShow(tvShowId).value?.data!!.mTvShow
        Mockito.verify(filmRepository).getTvShowById(Integer.parseInt(tvShowId))
        TestCase.assertNotNull(tvShowEntities)
        TestCase.assertEquals(dummyTvShow.tvShowId, tvShowEntities.tvShowId)
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

        val genresEntities = viewModel.getTvShow(tvShowId).value?.data!!.mGenresTvShow
        TestCase.assertNotNull(genresEntities)
        TestCase.assertEquals(4, genresEntities.size.toLong())

        viewModel.getTvShow(tvShowId).observeForever(observer)
        Mockito.verify(observer).onChanged(Resource.success(dummyTvShowDetail))
    }
}