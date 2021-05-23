package com.dicodingapp.moviecatalogue.ui.tv_show

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicodingapp.moviecatalogue.data.source.remote.network.ApiConfig
import com.dicodingapp.moviecatalogue.databinding.FragmentTvShowBinding
import com.dicodingapp.moviecatalogue.ui.bookmark.BookmarkActivity
import com.dicodingapp.moviecatalogue.viewmodel.ViewModelFactory
import com.dicodingapp.moviecatalogue.vo.Status

class TvShowFragment : Fragment() {

    private var fragmentTvShowBinding: FragmentTvShowBinding? = null
    private val binding get() = fragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory =
                ViewModelFactory.getInstance(requireActivity(), ApiConfig.provideApiService())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()

            viewModel.getTvShow().observe(requireActivity(), { tvShows ->
                if (tvShows != null) {
                    when (tvShows.status) {
                        Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            tvShowAdapter.setTvShows(tvShows.data)
                            tvShowAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, tvShows.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding?.rvTvShow) {
                this?.layoutManager = GridLayoutManager(context, 2)
                this?.setHasFixedSize(true)
                this?.adapter = tvShowAdapter
            }

            binding?.btn?.setOnClickListener {
                val intent = Intent(context, BookmarkActivity::class.java)
                intent.putExtra(BookmarkActivity.EXTRA_BOOKMARK, "2")
                startActivity(intent)
            }
        }
    }
}
