package com.dicodingapp.moviecatalogue.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicodingapp.moviecatalogue.R
import com.dicodingapp.moviecatalogue.data.MovieEntity
import com.dicodingapp.moviecatalogue.data.TvShowEntity
import com.dicodingapp.moviecatalogue.data.source.remote.network.ApiConfig
import com.dicodingapp.moviecatalogue.databinding.ActivityDetailFilmBinding
import com.dicodingapp.moviecatalogue.databinding.ContentDetailFilmBinding
import com.dicodingapp.moviecatalogue.utils.Converting
import com.dicodingapp.moviecatalogue.utils.Converting.formatDollar
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefaultBackdrop
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefaultPoster
import com.dicodingapp.moviecatalogue.viewmodel.ViewModelFactory

class DetailFilmActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var detailContentBinding: ContentDetailFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailBinding.detailContent

        setContentView(activityDetailBinding.root)

        activityDetailBinding.imgBack.setOnClickListener {
            onBackPressed()
        }

        val factory = ViewModelFactory.getInstance(ApiConfig.provideApiService())
        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailFilmViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                activityDetailBinding.tvDetail.text = getString(R.string.text_detail_movie)

                activityDetailBinding.progressBar.visibility = View.VISIBLE
                activityDetailBinding.content.visibility = View.GONE
                viewModel.getMovie(movieId).observe(this, { movies ->
                    activityDetailBinding.progressBar.visibility = View.GONE
                    activityDetailBinding.content.visibility = View.VISIBLE
                    populateMovie(movies)
                })
            }
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                activityDetailBinding.tvDetail.text = getString(R.string.text_detail_tv_show)

                activityDetailBinding.progressBar.visibility = View.VISIBLE
                activityDetailBinding.content.visibility = View.GONE
                viewModel.getTvShow(tvShowId).observe(this, { tvShow ->
                    activityDetailBinding.progressBar.visibility = View.GONE
                    activityDetailBinding.content.visibility = View.VISIBLE
                    populateTvShow(tvShow)
                })
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateMovie(movieEntity: MovieEntity) {
        detailContentBinding.apply {
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

            tvGenre.text = movieEntity.genres.joinToString { it.genreName }

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
            castAdapter.setCasts(movieEntity.casts)
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
    private fun populateTvShow(tvShowEntity: TvShowEntity) {
        detailContentBinding.apply {
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

            tvGenre.text = tvShowEntity.genres.joinToString { it.genreName }

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

            val castAdapter = CastAdapter()
            castAdapter.setCasts(tvShowEntity.casts)
            with(rvCast) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = castAdapter
            }

            lastEpisodeToAir.visibility = View.VISIBLE
            cvLastEpisode.visibility = View.VISIBLE
            tvNameSeason.text = tvShowEntity.lastEpisodeToAir?.name
            tvDateSeason.text = tvShowEntity.lastEpisodeToAir?.air_date
            tvTotalSeason.text =
                getString(R.string.text_episodes, tvShowEntity.lastEpisodeToAir?.episodeNumber)
            tvOverviewSeason.text = tvShowEntity.lastEpisodeToAir?.overview
            setImageDefaultBackdrop(
                this@DetailFilmActivity,
                tvShowEntity.lastEpisodeToAir?.stillPath,
                imgPosterSeason
            )
        }
    }
}
