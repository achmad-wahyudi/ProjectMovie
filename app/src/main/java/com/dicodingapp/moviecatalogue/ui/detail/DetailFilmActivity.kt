package com.dicodingapp.moviecatalogue.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.dicodingapp.moviecatalogue.R
import com.dicodingapp.moviecatalogue.data.MovieEntity
import com.dicodingapp.moviecatalogue.data.TvShowEntity
import com.dicodingapp.moviecatalogue.databinding.ActivityDetailFilmBinding
import com.dicodingapp.moviecatalogue.databinding.ContentDetailFilmBinding
import com.dicodingapp.moviecatalogue.utils.Converting
import com.dicodingapp.moviecatalogue.utils.Converting.formatDollar
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefault
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefaultBackdrop

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

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailFilmViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                activityDetailBinding.tvDetail.text = getString(R.string.text_detail_movie)
                populateMovie(viewModel.getMovie())
            }
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId)
                activityDetailBinding.tvDetail.text = getString(R.string.text_detail_tv_show)
                populateTvShow(viewModel.getTvShow())
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

        detailContentBinding.tvGenre.text = movieEntity.genres.joinToString { ", ${it.genreName}" }

        try {
            val resources = this.resources.getIdentifier(
                movieEntity.posterPath,
                "drawable",
                this.packageName
            )
            setImageDefault(
                this,
                resources,
                detailContentBinding.imgPoster
            )
        } catch (e: Exception) {
            Glide.with(this)
                .load(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_broken_image_black
                    )
                )
                .into(detailContentBinding.imgPoster)
            e.printStackTrace()
        }

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

        detailContentBinding.tvGenre.text = tvShowEntity.genres.joinToString { ", ${it.genreName}" }

        try {
            val resources = this.resources.getIdentifier(
                tvShowEntity.posterPath,
                "drawable",
                this.packageName
            )
            setImageDefault(
                this,
                resources,
                detailContentBinding.imgPoster
            )
        } catch (e: Exception) {
            Glide.with(this)
                .load(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_broken_image_black
                    )
                )
                .into(detailContentBinding.imgPoster)
            e.printStackTrace()
        }

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
        detailContentBinding.tvNameSeason.text = tvShowEntity.lastEpisodeToAir.name
        detailContentBinding.tvDateSeason.text = tvShowEntity.lastEpisodeToAir.air_date
        detailContentBinding.tvTotalSeason.text =
            getString(R.string.text_episodes, tvShowEntity.lastEpisodeToAir.episodeNumber)
        detailContentBinding.tvOverviewSeason.text = tvShowEntity.lastEpisodeToAir.overview
        setImageDefaultBackdrop(
            this,
            tvShowEntity.lastEpisodeToAir.stillPath,
            detailContentBinding.imgPosterSeason
        )
    }
}
