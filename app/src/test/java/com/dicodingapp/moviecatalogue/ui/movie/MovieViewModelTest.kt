package com.dicodingapp.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicodingapp.moviecatalogue.data.MovieEntity
import com.dicodingapp.moviecatalogue.data.source.FilmRepository
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
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(filmRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDummyMovie()
        val movie = MutableLiveData<List<MovieEntity>>()
        movie.value = dummyMovies

        Mockito.`when`(filmRepository.getAllMovie()).thenReturn(movie)
        val movieEntities = viewModel.getMovies().value
        Mockito.verify(filmRepository).getAllMovie()
        TestCase.assertNotNull(movieEntities)
        TestCase.assertEquals(19, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }
}