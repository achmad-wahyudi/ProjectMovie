package com.dicodingapp.moviecatalogue.ui.movie

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicodingapp.moviecatalogue.R
import com.dicodingapp.moviecatalogue.data.MovieEntity
import com.dicodingapp.moviecatalogue.databinding.ItemsMovieBinding
import com.dicodingapp.moviecatalogue.ui.detail.DetailFilmActivity
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefault

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movie: List<MovieEntity>?) {
        if (movie == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size


    class MovieViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDate.text = movie.releaseDate

                val vote = (movie.voteAverage * 10).toInt()
                tvItemVote.text = "${vote}%"

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_MOVIE, movie.movieId)
                    itemView.context.startActivity(intent)
                }
                try {
                    val resources = itemView.context.resources.getIdentifier(
                        movie.posterPath,
                        "drawable",
                        itemView.context.packageName
                    )
                    setImageDefault(
                        itemView.context,
                        resources,
                        imgPoster
                    )
                } catch (e: Exception) {
                    Glide.with(itemView.context)
                        .load(
                            ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.ic_broken_image_black
                            )
                        )
                        .into(imgPoster)
                    e.printStackTrace()
                }
            }
        }
    }
}