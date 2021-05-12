package com.dicodingapp.moviecatalogue.ui.tv_show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicodingapp.moviecatalogue.data.source.remote.network.ApiConfig
import com.dicodingapp.moviecatalogue.databinding.FragmentTvShowBinding
import com.dicodingapp.moviecatalogue.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(ApiConfig.provideApiService())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()

            fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
            fragmentTvShowBinding.rvTvShow.visibility = View.GONE
            viewModel.getTvShow().observe(viewLifecycleOwner, { tvShows ->
                fragmentTvShowBinding.progressBar.visibility = View.GONE
                fragmentTvShowBinding.rvTvShow.visibility = View.VISIBLE
                tvShowAdapter.setTvShows(tvShows)
                tvShowAdapter.notifyDataSetChanged()
            })
            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }
}
