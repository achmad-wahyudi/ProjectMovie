package com.dicodingapp.moviecatalogue.ui.movie.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicodingapp.moviecatalogue.data.FilmRepository
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieWithGenreAndCast
import com.dicodingapp.moviecatalogue.ui.detail.DetailFilmViewModel
import com.dicodingapp.moviecatalogue.utils.DataDummy
import com.dicodingapp.moviecatalogue.vo.Resource
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
    private val dummyMovieDetail = DataDummy.generateDummyMovieWithGenreAndCast(dummyMovie)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<MovieWithGenreAndCast>>

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel(filmRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {

        val movie = MutableLiveData<Resource<MovieWithGenreAndCast>>()
        movie.value = Resource.success(dummyMovieDetail)

        Mockito.`when`(filmRepository.getMovieById(Integer.parseInt(movieId))).thenReturn(movie)
        viewModel.movieModule.observeForever(observer)

        val movieEntities = viewModel.movieModule.value?.data!!.mMovie
        Mockito.verify(filmRepository).getMovieById(Integer.parseInt(movieId))
        assertNotNull(movieEntities)
        assertEquals(dummyMovie.movieId, movieEntities.movieId)
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

        val genresEntities = viewModel.movieModule.value?.data!!.mGenres
        assertNotNull(genresEntities)
        assertEquals(4, genresEntities.size.toLong())

        viewModel.movieModule.observeForever(observer)
        Mockito.verify(observer).onChanged(Resource.success(dummyMovieDetail))
    }
}