package com.dicodingapp.moviecatalogue.ui.bookmark

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicodingapp.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicodingapp.moviecatalogue.databinding.ItemsTvShowBinding
import com.dicodingapp.moviecatalogue.ui.detail.DetailFilmActivity
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper

class BookmarkTvShowAdapter : RecyclerView.Adapter<BookmarkTvShowAdapter.TvShowViewHolder>() {
    private var listTvShows = ArrayList<TvShowEntity>()

    fun setTvShows(tvShow: List<TvShowEntity>?) {
        if (tvShow == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding =
            ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size

    class TvShowViewHolder(private val binding: ItemsTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvItemTitleTv.text = tvShow.name
                tvItemDateTv.text = tvShow.firstAirDate

                val vote = (tvShow.voteAverage * 10).toInt()
                tvItemVoteTv.text = "${vote}%"

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_TV_SHOW, tvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }
                ImageViewHelper.setImageDefaultPoster(
                    itemView.context,
                    tvShow.posterPath,
                    imgPosterTv
                )
            }
        }
    }
}