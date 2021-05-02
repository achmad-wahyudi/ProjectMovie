package com.dicodingapp.moviecatalogue.ui.tv_show.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.dicodingapp.moviecatalogue.R
import com.dicodingapp.moviecatalogue.data.TvShowEntity
import com.dicodingapp.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.dicodingapp.moviecatalogue.databinding.ContentDetailTvShowBinding
import com.dicodingapp.moviecatalogue.ui.movie.detail.CastAdapter
import com.dicodingapp.moviecatalogue.utils.Converting.formatNumber
import com.dicodingapp.moviecatalogue.utils.DefineUI.changeStatusBarColor
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefault
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefaultBackdrop

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var detailContentBinding: ContentDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailTvShowBinding.detailContentTvShow

        setContentView(activityDetailTvShowBinding.root)
        changeStatusBarColor(window)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        activityDetailTvShowBinding.imgBackTv.setOnClickListener {
            onBackPressed()
        }

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId)
                populateTvShow(viewModel.getTvShow())
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateTvShow(tvShowEntity: TvShowEntity) {
        detailContentBinding.tvTitleTv.text = tvShowEntity.name
        detailContentBinding.tvTagLineTv.text = tvShowEntity.tagLine
        detailContentBinding.tvDateTv.text = tvShowEntity.firstAirDate
        detailContentBinding.tvOverviewTv.text = tvShowEntity.overview
        detailContentBinding.tvStatusTv.text = tvShowEntity.status
        detailContentBinding.tvNumberOfEpisodesTv.text =
            formatNumber(tvShowEntity.numberOfEpisodes.toString())
        detailContentBinding.tvNumberOfSeasonsTv.text =
            formatNumber(tvShowEntity.numberOfSeasons.toString())

        val vote = (tvShowEntity.voteAverage * 10).toInt()
        detailContentBinding.tvVoteTv.text = "${vote}%"

        var genres = ""
        for (genresEntity in tvShowEntity.genres) {
            genres += if (genres.isEmpty()) {
                genresEntity.genreName
            } else {
                ", ${genresEntity.genreName}"
            }
        }
        detailContentBinding.tvGenreTv.text = genres

        try {
            val resources = this.resources.getIdentifier(
                tvShowEntity.posterPath,
                "drawable",
                this.packageName
            )
            setImageDefault(
                this,
                resources,
                detailContentBinding.imgPosterTv
            )
        } catch (e: Exception) {
            Glide.with(this)
                .load(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_broken_image_black
                    )
                )
                .into(detailContentBinding.imgPosterTv)
            e.printStackTrace()
        }

        setImageDefaultBackdrop(
            this,
            tvShowEntity.backdropPath,
            detailContentBinding.imgBackdropTv
        )

        val castAdapter = CastAdapter()
        castAdapter.setCasts(tvShowEntity.casts)
        with(detailContentBinding.rvCastTv) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = castAdapter
        }

        detailContentBinding.tvNameSeasonTv.text = tvShowEntity.lastEpisodeToAir.name
        detailContentBinding.tvDateSeasonTv.text = tvShowEntity.lastEpisodeToAir.air_date
        detailContentBinding.tvTotalSeasonTv.text =
            getString(R.string.text_episodes, tvShowEntity.lastEpisodeToAir.episodeNumber)
        detailContentBinding.tvOverviewSeasonTv.text = tvShowEntity.lastEpisodeToAir.overview
        setImageDefaultBackdrop(
            this,
            tvShowEntity.lastEpisodeToAir.stillPath,
            detailContentBinding.imgPosterSeasonTv
        )
    }

}
