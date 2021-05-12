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
        detailContentBinding.tvTitle.text = movieEntity.title
        detailContentBinding.tvTagLine.text = movieEntity.tagLine
        detailContentBinding.tvDate.text = movieEntity.releaseDate
        detailContentBinding.tvOverview.text = movieEntity.overview
        detailContentBinding.tvStatus.text = movieEntity.status

        detailContentBinding.budget.visibility = View.VISIBLE
        detailContentBinding.tvBudget.visibility = View.VISIBLE
        detailContentBinding.revenue.visibility = View.VISIBLE
        detailContentBinding.tvRevenue.visibility = View.VISIBLE
        detailContentBinding.tvBudget.text = formatDollar(movieEntity.budget.toString())
        detailContentBinding.tvRevenue.text = formatDollar(movieEntity.revenue.toString())

        val vote = (movieEntity.voteAverage * 10).toInt()
        detailContentBinding.tvVote.text = "${vote}%"

        detailContentBinding.tvGenre.text = movieEntity.genres.joinToString { it.genreName }

        setImageDefaultPoster(
            this,
            movieEntity.posterPath,
            detailContentBinding.imgPoster
        )

        setImageDefaultBackdrop(
            this,
            movieEntity.backdropPath,
            detailContentBinding.imgBackdrop
        )

        val castAdapter = CastAdapter()
        castAdapter.setCasts(movieEntity.casts)
        with(detailContentBinding.rvCast) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = castAdapter
        }

        detailContentBinding.lastEpisodeToAir.visibility = View.GONE
        detailContentBinding.cvLastEpisode.visibility = View.GONE
    }

    @SuppressLint("SetTextI18n")
    private fun populateTvShow(tvShowEntity: TvShowEntity) {
        detailContentBinding.tvTitle.text = tvShowEntity.name
        detailContentBinding.tvTagLine.text = tvShowEntity.tagLine
        detailContentBinding.tvDate.text = tvShowEntity.firstAirDate
        detailContentBinding.tvOverview.text = tvShowEntity.overview
        detailContentBinding.tvStatus.text = tvShowEntity.status

        detailContentBinding.numberOfEpisodes.visibility = View.VISIBLE
        detailContentBinding.numberOfSeasons.visibility = View.VISIBLE
        detailContentBinding.tvNumberOfEpisodes.visibility = View.VISIBLE
        detailContentBinding.tvNumberOfSeasons.visibility = View.VISIBLE
        detailContentBinding.tvNumberOfEpisodes.text =
            Converting.formatNumber(tvShowEntity.numberOfEpisodes.toString())
        detailContentBinding.tvNumberOfSeasons.text =
            Converting.formatNumber(tvShowEntity.numberOfSeasons.toString())

        val vote = (tvShowEntity.voteAverage * 10).toInt()
        detailContentBinding.tvVote.text = "${vote}%"

        detailContentBinding.tvGenre.text = tvShowEntity.genres.joinToString { it.genreName }

        setImageDefaultPoster(
            this,
            tvShowEntity.posterPath,
            detailContentBinding.imgPoster
        )

        setImageDefaultBackdrop(
            this,
            tvShowEntity.backdropPath,
            detailContentBinding.imgBackdrop
        )

        val castAdapter = CastAdapter()
        castAdapter.setCasts(tvShowEntity.casts)
        with(detailContentBinding.rvCast) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = castAdapter
        }

        detailContentBinding.lastEpisodeToAir.visibility = View.VISIBLE
        detailContentBinding.cvLastEpisode.visibility = View.VISIBLE
        detailContentBinding.tvNameSeason.text = tvShowEntity.lastEpisodeToAir?.name
        detailContentBinding.tvDateSeason.text = tvShowEntity.lastEpisodeToAir?.air_date
        detailContentBinding.tvTotalSeason.text =
            getString(R.string.text_episodes, tvShowEntity.lastEpisodeToAir?.episodeNumber)
        detailContentBinding.tvOverviewSeason.text = tvShowEntity.lastEpisodeToAir?.overview
        setImageDefaultBackdrop(
            this,
            tvShowEntity.lastEpisodeToAir?.stillPath,
            detailContentBinding.imgPosterSeason
        )
    }
}
