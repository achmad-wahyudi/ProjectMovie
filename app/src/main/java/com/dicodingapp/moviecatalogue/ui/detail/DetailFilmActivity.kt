package com.dicodingapp.moviecatalogue.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicodingapp.moviecatalogue.R
import com.dicodingapp.moviecatalogue.data.source.local.entity.MovieWithGenreAndCast
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowWithGenreAndCastAndLastEpisode
import com.dicodingapp.moviecatalogue.data.source.remote.network.ApiConfig
import com.dicodingapp.moviecatalogue.databinding.ActivityDetailFilmBinding
import com.dicodingapp.moviecatalogue.databinding.ContentDetailFilmBinding
import com.dicodingapp.moviecatalogue.utils.Converting
import com.dicodingapp.moviecatalogue.utils.Converting.formatDollar
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefaultBackdrop
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefaultPoster
import com.dicodingapp.moviecatalogue.viewmodel.ViewModelFactory
import com.dicodingapp.moviecatalogue.vo.Status

class DetailFilmActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private var _detailContentBinding: ContentDetailFilmBinding? = null
    private val binding get() = _detailContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        _detailContentBinding = activityDetailBinding.detailContent

        setContentView(activityDetailBinding.root)

        activityDetailBinding.imgBack.setOnClickListener {
            onBackPressed()
        }

        val factory = ViewModelFactory.getInstance(this, ApiConfig.provideApiService())
        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailFilmViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                activityDetailBinding.tvDetail.text = getString(R.string.text_detail_movie)

                activityDetailBinding.imgBookmark.visibility = View.GONE

                viewModel.setSelectedMovie(movieId)
                viewModel.movieModule.observe(this, { movies ->
                    if (movies != null) {
                        when (movies.status) {
                            Status.LOADING -> {
                                activityDetailBinding.progressBar.visibility = View.VISIBLE
                                activityDetailBinding.content.visibility = View.GONE
                            }
                            Status.SUCCESS -> {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                activityDetailBinding.content.visibility = View.VISIBLE
                                populateMovie(movies.data!!)

                                activityDetailBinding.imgBookmark.visibility = View.VISIBLE
                                setBookmarkState(
                                    activityDetailBinding.imgBookmark,
                                    movies.data.mMovie.bookmarked
                                )
                                activityDetailBinding.imgBookmark.setOnClickListener {
                                    viewModel.setBookmarkMovie()
                                }
                            }
                            Status.ERROR -> {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                activityDetailBinding.content.visibility = View.VISIBLE
                                Toast.makeText(this, movies.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                activityDetailBinding.tvDetail.text = getString(R.string.text_detail_tv_show)

                activityDetailBinding.imgBookmark.visibility = View.GONE

                viewModel.setSelectedTvShow(tvShowId)
                viewModel.tvShowModule.observe(this, { tvShow ->
                    if (tvShow != null) {
                        when (tvShow.status) {
                            Status.LOADING -> {
                                activityDetailBinding.progressBar.visibility = View.VISIBLE
                                activityDetailBinding.content.visibility = View.GONE
                            }
                            Status.SUCCESS -> {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                activityDetailBinding.content.visibility = View.VISIBLE
                                populateTvShow(tvShow.data!!)

                                activityDetailBinding.imgBookmark.visibility = View.VISIBLE
                                setBookmarkState(
                                    activityDetailBinding.imgBookmark,
                                    tvShow.data.mTvShow.bookmarked
                                )
                                activityDetailBinding.imgBookmark.setOnClickListener {
                                    viewModel.setBookmarkTvShow()
                                }
                            }
                            Status.ERROR -> {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                activityDetailBinding.content.visibility = View.VISIBLE
                                Toast.makeText(this, tvShow.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }
    }

    private fun setBookmarkState(imgBookmark: ImageView, state: Boolean) {
        if (state) {
            imgBookmark.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_bookmarked_white
                )
            )
        } else {
            imgBookmark.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_bookmark_white
                )
            )
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateMovie(movieWithGenreAndCast: MovieWithGenreAndCast) {
        binding?.apply {
            val movieEntity = movieWithGenreAndCast.mMovie
            val genres = movieWithGenreAndCast.mGenres
            val casts = movieWithGenreAndCast.mCast
            tvTitle.text = movieEntity.title
            tvTagLine.text = movieEntity.tagLine
            tvDate.text = movieEntity.releaseDate
            tvOverview.text = movieEntity.overview
            tvStatus.text = movieEntity.status

            budget.visibility = View.VISIBLE
            tvBudget.visibility = View.VISIBLE
            revenue.visibility = View.VISIBLE
            tvRevenue.visibility = View.VISIBLE
            tvBudget.text = formatDollar(movieEntity.budget.toString())
            tvRevenue.text = formatDollar(movieEntity.revenue.toString())

            val vote = (movieEntity.voteAverage * 10).toInt()
            tvVote.text = "${vote}%"

            tvGenre.text = genres.joinToString { it.genreName }

            setImageDefaultPoster(
                this@DetailFilmActivity,
                movieEntity.posterPath,
                imgPoster
            )

            setImageDefaultBackdrop(
                this@DetailFilmActivity,
                movieEntity.backdropPath,
                imgBackdrop
            )

            val castAdapter = CastAdapter()
            castAdapter.setCasts(casts)
            with(rvCast) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = castAdapter
            }

            lastEpisodeToAir.visibility = View.GONE
            cvLastEpisode.visibility = View.GONE
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateTvShow(tvShowWithGenreAndCastAndLastEpisode: TvShowWithGenreAndCastAndLastEpisode) {
        binding?.apply {
            val tvShowEntity = tvShowWithGenreAndCastAndLastEpisode.mTvShow
            val genres = tvShowWithGenreAndCastAndLastEpisode.mGenresTvShow
            val casts = tvShowWithGenreAndCastAndLastEpisode.mCastTvShow
            val mLastEpisodeToAir = tvShowWithGenreAndCastAndLastEpisode.mLastEpisode
            tvTitle.text = tvShowEntity.name
            tvTagLine.text = tvShowEntity.tagLine
            tvDate.text = tvShowEntity.firstAirDate
            tvOverview.text = tvShowEntity.overview
            tvStatus.text = tvShowEntity.status

            numberOfEpisodes.visibility = View.VISIBLE
            numberOfSeasons.visibility = View.VISIBLE
            tvNumberOfEpisodes.visibility = View.VISIBLE
            tvNumberOfSeasons.visibility = View.VISIBLE
            tvNumberOfEpisodes.text =
                Converting.formatNumber(tvShowEntity.numberOfEpisodes.toString())
            tvNumberOfSeasons.text =
                Converting.formatNumber(tvShowEntity.numberOfSeasons.toString())

            val vote = (tvShowEntity.voteAverage * 10).toInt()
            tvVote.text = "${vote}%"

            tvGenre.text = genres.joinToString { it.genreName }

            setImageDefaultPoster(
                this@DetailFilmActivity,
                tvShowEntity.posterPath,
                imgPoster
            )

            setImageDefaultBackdrop(
                this@DetailFilmActivity,
                tvShowEntity.backdropPath,
                imgBackdrop
            )

            val castAdapter = CastTvShowAdapter()
            castAdapter.setCasts(casts)
            with(rvCast) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = castAdapter
            }

            lastEpisodeToAir.visibility = View.VISIBLE
            cvLastEpisode.visibility = View.VISIBLE
            tvNameSeason.text = mLastEpisodeToAir!!.name
            tvDateSeason.text = mLastEpisodeToAir.air_date
            tvTotalSeason.text =
                getString(R.string.text_episodes, mLastEpisodeToAir.episodeNumber)
            tvOverviewSeason.text = mLastEpisodeToAir.overview
            setImageDefaultBackdrop(
                this@DetailFilmActivity,
                mLastEpisodeToAir.stillPath,
                imgPosterSeason
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _detailContentBinding = null
    }
}
