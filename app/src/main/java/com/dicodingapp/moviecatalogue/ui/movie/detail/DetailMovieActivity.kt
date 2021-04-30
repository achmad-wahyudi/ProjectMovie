package com.dicodingapp.moviecatalogue.ui.movie.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicodingapp.moviecatalogue.R
import com.dicodingapp.moviecatalogue.data.MovieEntity
import com.dicodingapp.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.dicodingapp.moviecatalogue.databinding.ContentDetailMovieBinding
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefault

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

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

    private fun populateMovie(movieEntity: MovieEntity) {
        detailContentBinding.textTitle.text = movieEntity.title
        detailContentBinding.textDate.text =
            resources.getString(R.string.deadline_date, movieEntity.tagLine)


        try {
            setImageDefault(
                this,
                ContextCompat.getDrawable(this, movieEntity.posterPath),
                detailContentBinding.imagePoster
            )
        } catch (e: Exception) {
            Glide.with(this)
                .load(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_broken_image_black
                    )
                )
                .into(detailContentBinding.imagePoster)
            e.printStackTrace()
        }
    }

}
