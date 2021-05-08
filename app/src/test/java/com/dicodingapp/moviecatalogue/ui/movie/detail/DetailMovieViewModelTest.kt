package com.dicodingapp.moviecatalogue.ui.movie.detail

import com.dicodingapp.moviecatalogue.ui.detail.DetailFilmViewModel
import com.dicodingapp.moviecatalogue.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailFilmViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.movieId

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.status, movieEntity.status)
        assertEquals(dummyMovie.tagLine, movieEntity.tagLine)
        assertEquals(dummyMovie.voteAverage, movieEntity.voteAverage)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.backdropPath, movieEntity.backdropPath)
        assertEquals(dummyMovie.budget, movieEntity.budget)
        assertEquals(dummyMovie.revenue, movieEntity.revenue)

        val genresEntities = viewModel.getMovie().genres
        assertNotNull(genresEntities)
        assertEquals(3, genresEntities.size.toLong())

        val castsEntities = viewModel.getMovie().casts
        assertNotNull(castsEntities)
        assertEquals(6, castsEntities.size.toLong())
    }
}