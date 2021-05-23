package com.dicodingapp.moviecatalogue.ui.tv_show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicodingapp.moviecatalogue.data.FilmRepository
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
class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<TvShowEntity>>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(filmRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShows = Resource.success(DataDummy.generateDummyTvShow())
        val tvShow = MutableLiveData<Resource<List<TvShowEntity>>>()
        tvShow.value = dummyTvShows

        Mockito.`when`(filmRepository.getAllTvShow()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShow().value?.data
        Mockito.verify(filmRepository).getAllTvShow()
        TestCase.assertNotNull(tvShowEntities)
        TestCase.assertEquals(1, tvShowEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShows)
    }
}