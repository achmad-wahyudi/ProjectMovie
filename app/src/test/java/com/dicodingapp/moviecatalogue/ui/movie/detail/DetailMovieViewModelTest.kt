package com.dicodingapp.moviecatalogue.ui.movie.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicodingapp.moviecatalogue.data.MovieEntity
import com.dicodingapp.moviecatalogue.data.source.FilmRepository
import com.dicodingapp.moviecatalogue.ui.detail.DetailFilmViewModel
import com.dicodingapp.moviecatalogue.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailFilmViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel(filmRepository)
    }

    @Test
    fun getMovie() {

        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        Mockito.`when`(filmRepository.getMovieById(Integer.parseInt(movieId))).thenReturn(movie)
        val movieEntities = viewModel.getMovie(movieId).value
        Mockito.verify(filmRepository).getMovieById(Integer.parseInt(movieId))
        assertNotNull(movieEntities)
        assertEquals(dummyMovie.movieId, movieEntities!!.movieId)
        assertEquals(dummyMovie.title, movieEntities.title)
        assertEquals(dummyMovie.releaseDate, movieEntities.releaseDate)
        assertEquals(dummyMovie.status, movieEntities.status)
        assertEquals(dummyMovie.tagLine, movieEntities.tagLine)
        assertEquals(dummyMovie.voteAverage, movieEntities.voteAverage)
        assertEquals(dummyMovie.posterPath, movieEntities.posterPath)
        assertEquals(dummyMovie.overview, movieEntities.overview)
        assertEquals(dummyMovie.backdropPath, movieEntities.backdropPath)
        assertEquals(dummyMovie.budget, movieEntities.budget)
        assertEquals(dummyMovie.revenue, movieEntities.revenue)

        val genresEntities = movieEntities.genres
        assertNotNull(genresEntities)
        assertEquals(4, genresEntities.size.toLong())

        viewModel.getMovie(movieId).observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovie)
    }
}