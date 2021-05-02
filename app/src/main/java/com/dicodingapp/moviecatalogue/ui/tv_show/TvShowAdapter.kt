package com.dicodingapp.moviecatalogue.ui.tv_show

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicodingapp.moviecatalogue.R
import com.dicodingapp.moviecatalogue.data.TvShowEntity
import com.dicodingapp.moviecatalogue.databinding.ItemsTvShowBinding
import com.dicodingapp.moviecatalogue.ui.tv_show.detail.DetailTvShowActivity
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefault

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
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
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }
                try {
                    val resources = itemView.context.resources.getIdentifier(
                        tvShow.posterPath,
                        "drawable",
                        itemView.context.packageName
                    )
                    setImageDefault(
                        itemView.context,
                        resources,
                        imgPosterTv
                    )
                } catch (e: Exception) {
                    Glide.with(itemView.context)
                        .load(
                            ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.ic_broken_image_black
                            )
                        )
                        .into(imgPosterTv)
                    e.printStackTrace()
                }
            }
        }
    }
}