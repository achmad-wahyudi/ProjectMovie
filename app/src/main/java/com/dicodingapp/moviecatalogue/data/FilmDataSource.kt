package com.dicodingapp.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieWithGenreAndCast
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowWithGenreAndCastAndLastEpisode
import com.dicodingapp.moviecatalogue.vo.Resource

interface FilmDataSource {
    fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getMovieById(movieId: Int): LiveData<Resource<MovieWithGenreAndCast>>

    fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getTvShowById(tvShowId: Int): LiveData<Resource<TvShowWithGenreAndCastAndLastEpisode>>

    fun getAllBookmarkedMovie(): LiveData<PagedList<MovieEntity>>

    fun setMovieBookmark(movie: MovieEntity, state: Boolean)

    fun getAllBookmarkedTvShow(): LiveData<PagedList<TvShowEntity>>

    fun setTvShowBookmark(tvShow: TvShowEntity, state: Boolean)
}