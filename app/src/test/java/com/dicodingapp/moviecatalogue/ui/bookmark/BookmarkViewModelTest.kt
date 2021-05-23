package com.dicodingapp.moviecatalogue.ui.bookmark

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicodingapp.moviecatalogue.data.FilmRepository
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowEntity
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {
    private lateinit var viewModel: BookmarkViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var observerTvShow: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedListTvShow: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel(filmRepository)
    }

    @Test
    fun getAllBookmarkedMovie() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(5)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummyMovies

        `when`(filmRepository.getAllBookmarkedMovie()).thenReturn(movie)
        val movieEntities = viewModel.getMovies().value
        Mockito.verify(filmRepository).getAllBookmarkedMovie()
        TestCase.assertNotNull(movieEntities)
        TestCase.assertEquals(5, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getAllBookmarkedTvShow() {
        val dummyTvShows = pagedListTvShow
        `when`(dummyTvShows.size).thenReturn(5)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyTvShows

        `when`(filmRepository.getAllBookmarkedTvShow()).thenReturn(tvShow)

        val tvShowEntities = viewModel.getTvShow().value
        Mockito.verify(filmRepository).getAllBookmarkedTvShow()
        TestCase.assertNotNull(tvShowEntities)
        TestCase.assertEquals(5, tvShowEntities?.size)

        viewModel.getTvShow().observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(dummyTvShows)
    }
}