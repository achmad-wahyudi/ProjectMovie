package com.dicodingapp.moviecatalogue.ui.movie.detail

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
import com.dicodingapp.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.dicodingapp.moviecatalogue.databinding.ContentDetailMovieBinding
import com.dicodingapp.moviecatalogue.utils.Converting.formatDollar
import com.dicodingapp.moviecatalogue.utils.DefineUI.changeStatusBarColor
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefault
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefaultBackdrop

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailContentBinding: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)
        changeStatusBarColor(window)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        activityDetailMovieBinding.imgBack.setOnClickListener {
            onBackPressed()
        }

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                populateMovie(viewModel.getMovie(this))
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun populateMovie(movieEntity: MovieEntity) {
        detailContentBinding.textTitle.text = movieEntity.title
        detailContentBinding.textTagLine.text = movieEntity.tagLine
        detailContentBinding.textDate.text = movieEntity.releaseDate
        detailContentBinding.textOverview.text = movieEntity.overview
        detailContentBinding.textStatus.text = movieEntity.status
        detailContentBinding.textBudget.text = formatDollar(movieEntity.budget.toString())
        detailContentBinding.textRevenue.text = formatDollar(movieEntity.revenue.toString())

        val vote = (movieEntity.voteAverage * 10).toInt()
        detailContentBinding.textVote.text = "${vote}%"

        var genres = ""
        for (genresEntity in movieEntity.genres) {
            genres += if (genres.isEmpty()) {
                genresEntity.genreName
            } else {
                ", ${genresEntity.genreName}"
            }
        }
        detailContentBinding.textGenre.text = genres

        try {
            setImageDefault(
                this,
                ContextCompat.getDrawable(this, movieEntity.posterPath),
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
    }

}
