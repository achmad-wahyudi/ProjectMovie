package com.dicodingapp.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicodingapp.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicodingapp.moviecatalogue.utils.DataDummy
import com.dicodingapp.moviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val filmRepository = FakeFilmRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovie()
    private val movieDetailResponses = DataDummy.generateRemoteDummyDetailMovie()
    private val movieId = movieDetailResponses.id

    private val tvShowResponses = DataDummy.generateRemoteDummyTvShow()
    private val tvShowDetailResponses = DataDummy.generateRemoteDummyDetailTvShow()
    private val tvShowId = tvShowDetailResponses.id

    @Test
    fun getAllMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMovieReceived(movieResponses)
            null
        }.`when`(remote).getAllMovie(any())
        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getAllMovie())
        verify(remote).getAllMovie(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getMovieById() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadMovieByIdCallback)
                .onMovieByIdReceived(movieDetailResponses)
            null
        }.`when`(remote).getMovieById(eq(movieId!!), any())

        val movieEntitiesContent =
            LiveDataTestUtil.getValue(filmRepository.getMovieById(movieId))

        verify(remote)
            .getMovieById(eq(movieId), any())

        assertEquals(movieId.toString(), movieEntitiesContent.movieId)
        assertNotNull(movieEntitiesContent)
        assertNotNull(movieEntitiesContent.movieId)
        assertNotNull(movieEntitiesContent.title)
    }

    @Test
    fun getAllTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowReceived(tvShowResponses)
            null
        }.`when`(remote).getAllTvShow(any())
        val tvShowEntities = LiveDataTestUtil.getValue(filmRepository.getAllTvShow())
        verify(remote).getAllTvShow(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getTvShowById() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadTvShowByIdCallback)
                .onTvShowByIdReceived(tvShowDetailResponses)
            null
        }.`when`(remote).getTvShowById(eq(tvShowId!!), any())

        val tvShowEntitiesContent =
            LiveDataTestUtil.getValue(filmRepository.getTvShowById(tvShowId))

        verify(remote)
            .getTvShowById(eq(tvShowId), any())

        assertEquals(tvShowId.toString(), tvShowEntitiesContent.tvShowId)
        assertNotNull(tvShowEntitiesContent)
        assertNotNull(tvShowEntitiesContent.tvShowId)
        assertNotNull(tvShowEntitiesContent.name)
    }

}