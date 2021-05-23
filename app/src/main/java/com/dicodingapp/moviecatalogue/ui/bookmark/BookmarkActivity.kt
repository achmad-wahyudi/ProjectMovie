package com.dicodingapp.moviecatalogue.ui.bookmark

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicodingapp.moviecatalogue.data.source.remote.network.ApiConfig
import com.dicodingapp.moviecatalogue.databinding.ActivityBookmarkBinding
import com.dicodingapp.moviecatalogue.viewmodel.ViewModelFactory

class BookmarkActivity : AppCompatActivity() {

    private var _activityBookmarkBinding: ActivityBookmarkBinding? = null
    private val binding get() = _activityBookmarkBinding

    companion object {
        const val EXTRA_BOOKMARK = "extra_bookmark"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityBookmarkBinding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(_activityBookmarkBinding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory =
            ViewModelFactory.getInstance(this, ApiConfig.provideApiService())
        val viewModel = ViewModelProvider(
            this,
            factory
        )[BookmarkViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val isBookmark = extras.getString(EXTRA_BOOKMARK)
            if (isBookmark != null) {
                if (isBookmark == "1") {
                    val movieAdapter = BookmarkMovieAdapter()
                    binding?.progressBar?.visibility = View.VISIBLE
                    viewModel.getMovies().observe(this, { movies ->
                        if (movies != null) {
                            binding?.progressBar?.visibility = View.GONE
                            movieAdapter.setMovies(movies)
                            movieAdapter.notifyDataSetChanged()
                        }
                    })

                    binding?.rvMovie?.layoutManager = GridLayoutManager(this, 2)
                    binding?.rvMovie?.setHasFixedSize(true)
                    binding?.rvMovie?.isNestedScrollingEnabled = false
                    binding?.rvMovie?.adapter = movieAdapter
                } else {
                    val movieAdapter = BookmarkTvShowAdapter()
                    binding?.progressBar?.visibility = View.VISIBLE
                    viewModel.getTvShow().observe(this, { tvShows ->
                        if (tvShows != null) {
                            binding?.progressBar?.visibility = View.GONE
                            movieAdapter.setTvShows(tvShows)
                            movieAdapter.notifyDataSetChanged()
                        }
                    })

                    binding?.rvMovie?.layoutManager = GridLayoutManager(this, 2)
                    binding?.rvMovie?.setHasFixedSize(true)
                    binding?.rvMovie?.isNestedScrollingEnabled = false
                    binding?.rvMovie?.adapter = movieAdapter
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
