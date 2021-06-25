package com.dicodingapp.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicodingapp.moviecatalogue.data.source.local.LocalDataSource
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieWithGenreAndCast
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowWithGenreAndCastAndLastEpisode
import com.dicodingapp.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicodingapp.moviecatalogue.utils.AppExecutors
import com.dicodingapp.moviecatalogue.utils.DataDummy
import com.dicodingapp.moviecatalogue.utils.LiveDataTestUtil
import com.dicodingapp.moviecatalogue.utils.PagedListUtil
import com.dicodingapp.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val filmRepository = FakeFilmRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovie()
    private val movieDetailResponses = DataDummy.generateRemoteDummyDetailMovie()
    private val movieId = movieDetailResponses.id

    private val tvShowResponses = DataDummy.generateRemoteDummyTvShow()
    private val tvShowDetailResponses = DataDummy.generateRemoteDummyDetailTvShow()
    private val tvShowId = tvShowDetailResponses.id

    @Test
    fun getAllMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        filmRepository.getAllMovie()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))

        verify(local).getAllMovie()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieById() {
        val dummyEntity = MutableLiveData<MovieWithGenreAndCast>()
        dummyEntity.value =
            DataDummy.generateDummyMovieWithGenreAndCast(DataDummy.generateDummyMovie()[0])
        `when`(local.getMovieById(movieId.toString())).thenReturn(dummyEntity)
        val movieEntities =
            LiveDataTestUtil.getValue(filmRepository.getMovieById(movieId!!))
        val movieEntitiesContent = movieEntities.data!!.mMovie
        verify(local).getMovieById(movieId.toString())
        assertEquals(movieId.toString(), movieEntitiesContent.movieId)
        assertNotNull(movieEntitiesContent)
        assertNotNull(movieEntitiesContent.movieId)
        assertNotNull(movieEntitiesContent.title)
    }

    @Test
    fun getAllTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShow()).thenReturn(dataSourceFactory)
        filmRepository.getAllTvShow()

        val tvShowEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))

        verify(local).getAllTvShow()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowById() {
        val dummyEntity = MutableLiveData<TvShowWithGenreAndCastAndLastEpisode>()
        dummyEntity.value =
            DataDummy.generateDummyTvShowWithGenreAndCastAndLastEpisode(DataDummy.generateDummyTvShow()[0])
        `when`(local.getTvShowById(tvShowId.toString())).thenReturn(dummyEntity)
        val tvShowEntities =
            LiveDataTestUtil.getValue(filmRepository.getTvShowById(tvShowId!!))
        val tvShowEntitiesContent = tvShowEntities.data!!.mTvShow
        verify(local).getTvShowById(tvShowId.toString())
        assertEquals(tvShowId.toString(), tvShowEntitiesContent.tvShowId)
        assertNotNull(tvShowEntitiesContent)
        assertNotNull(tvShowEntitiesContent.tvShowId)
        assertNotNull(tvShowEntitiesContent.name)
    }

    @Test
    fun getAllBookmarkedMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllBookmarkedMovie()).thenReturn(dataSourceFactory)
        filmRepository.getAllBookmarkedMovie()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))

        verify(local).getAllBookmarkedMovie()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllBookmarkedTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllBookmarkedTvShow()).thenReturn(dataSourceFactory)
        filmRepository.getAllBookmarkedTvShow()

        val tvShowEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))

        verify(local).getAllBookmarkedTvShow()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }
}