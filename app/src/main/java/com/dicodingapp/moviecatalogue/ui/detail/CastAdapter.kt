package com.dicodingapp.moviecatalogue.ui.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicodingapp.moviecatalogue.data.CastEntity
import com.dicodingapp.moviecatalogue.databinding.ItemsCastBinding
import com.dicodingapp.moviecatalogue.utils.ImageViewHelper.setImageDefaultBackdrop

class CastAdapter : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {
    private var listCasts = ArrayList<CastEntity>()

    fun setCasts(cast: List<CastEntity>?) {
        if (cast == null) return
        this.listCasts.clear()
        this.listCasts.addAll(cast)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val itemsCastBinding =
            ItemsCastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CastViewHolder(itemsCastBinding)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        val cast = listCasts[position]
        holder.bind(cast)
    }

    override fun getItemCount(): Int = listCasts.size

    class CastViewHolder(private val binding: ItemsCastBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(cast: CastEntity) {
            with(binding) {
                tvItemName.text = cast.name
                tvItemName2.text = cast.character

                setImageDefaultBackdrop(
                    itemView.context,
                    cast.profilePath,
                    imgPoster
                )
            }
        }
    }
}