package com.dicodingapp.moviecatalogue.ui.bookmark

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicodingapp.moviecatalogue.data.FilmRepository
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowEntity
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
class BookmarkViewModelTest {
    private lateinit var viewModel: BookmarkViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<List<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel(filmRepository)
    }

    @Test
    fun getAllBookmarkedMovie() {
        val dummyMovies = DataDummy.generateDummyMovie()
        val movie = MutableLiveData<List<MovieEntity>>()
        movie.value = dummyMovies

        Mockito.`when`(filmRepository.getAllBookmarkedMovie()).thenReturn(movie)
        val movieEntities = viewModel.getMovies().value
        Mockito.verify(filmRepository).getAllBookmarkedMovie()
        TestCase.assertNotNull(movieEntities)
        TestCase.assertEquals(1, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getAllBookmarkedTvShow() {
        val dummyTvShows = DataDummy.generateDummyTvShow()
        val tvShow = MutableLiveData<List<TvShowEntity>>()
        tvShow.value = dummyTvShows

        Mockito.`when`(filmRepository.getAllBookmarkedTvShow()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShow().value
        Mockito.verify(filmRepository).getAllBookmarkedTvShow()
        TestCase.assertNotNull(tvShowEntities)
        TestCase.assertEquals(1, tvShowEntities?.size)

        viewModel.getTvShow().observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(dummyTvShows)
    }
}