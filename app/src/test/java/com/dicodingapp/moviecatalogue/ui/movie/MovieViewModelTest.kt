package com.dicodingapp.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieEntity
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
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<MovieEntity>>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(filmRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(DataDummy.generateDummyMovie())
        val movie = MutableLiveData<Resource<List<MovieEntity>>>()
        movie.value = dummyMovies

        Mockito.`when`(filmRepository.getAllMovie()).thenReturn(movie)
        val movieEntities = viewModel.getMovies().value?.data
        Mockito.verify(filmRepository).getAllMovie()
        TestCase.assertNotNull(movieEntities)
        TestCase.assertEquals(1, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }
}