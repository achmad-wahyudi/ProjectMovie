package com.dicodingapp.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicodingapp.moviecatalogue.data.source.remote.network.ApiConfig
import com.dicodingapp.moviecatalogue.databinding.FragmentMovieBinding
import com.dicodingapp.moviecatalogue.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(ApiConfig.provideApiService())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()

            fragmentMovieBinding.progressBar.visibility = View.VISIBLE
            fragmentMovieBinding.rvMovie.visibility = View.GONE
            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                fragmentMovieBinding.progressBar.visibility = View.GONE
                fragmentMovieBinding.rvMovie.visibility = View.VISIBLE
                movieAdapter.setMovies(movies)
                movieAdapter.notifyDataSetChanged()
            })
            with(fragmentMovieBinding.rvMovie) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}
