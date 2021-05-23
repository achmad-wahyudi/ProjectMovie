package com.dicodingapp.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicodingapp.moviecatalogue.data.FilmRepository
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieWithGenreAndCast
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowWithGenreAndCastAndLastEpisode
import com.dicodingapp.moviecatalogue.vo.Resource

class DetailFilmViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    val movieId = MutableLiveData<String>()

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    var movieModule: LiveData<Resource<MovieWithGenreAndCast>> =
        Transformations.switchMap(movieId) { mMovieId ->
            filmRepository.getMovieById(Integer.parseInt(mMovieId))
        }

    val tvShowId = MutableLiveData<String>()

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId.value = tvShowId
    }

    var tvShowModule: LiveData<Resource<TvShowWithGenreAndCastAndLastEpisode>> =
        Transformations.switchMap(tvShowId) { mTvShowId ->
            filmRepository.getTvShowById(Integer.parseInt(mTvShowId))
        }

    fun setBookmarkMovie() {
        val movieResource = movieModule.value
        if (movieResource != null) {
            val movie = movieResource.data
            if (movie != null) {
                val movieEntity = movie.mMovie
                val newState = !movieEntity.bookmarked
                filmRepository.setMovieBookmark(movieEntity, newState)
            }
        }
    }

    fun setBookmarkTvShow() {
        val tvShowResource = tvShowModule.value
        if (tvShowResource != null) {
            val tvShow = tvShowResource.data
            if (tvShow != null) {
                val tvShowEntity = tvShow.mTvShow
                val newState = !tvShowEntity.bookmarked
                filmRepository.setTvShowBookmark(tvShowEntity, newState)
            }
        }
    }
}