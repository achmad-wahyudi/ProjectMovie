package com.dicodingapp.moviecatalogue.utils

import android.content.Context
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.dicodingapp.moviecatalogue.R

object ImageViewHelper {
    fun setImageDefault(activity: Context, image: Int?, ivPhoto: ImageView?) {
        try {
            val requestOption: RequestOptions = RequestOptions()
                .placeholder(R.drawable.ic_baseline_photo)
                .centerCrop()
            Glide.with(activity)
                .load(image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .thumbnail(
                    Glide.with(activity)
                        .load(image)
                        .apply(requestOption)
                )
                .apply(requestOption)
                .into(ivPhoto!!)
        } catch (e: Exception) {
            Glide.with(activity)
                .load(ContextCompat.getDrawable(activity, R.drawable.ic_broken_image_black))
                .into(ivPhoto!!)
            e.printStackTrace()
        }
    }

    fun setImageDefaultBackdrop(activity: Context, image: String?, ivPhoto: ImageView?) {
        try {
            val imageNew = ConstHelper.TEXT_URL_IMAGE + image
            val requestOption: RequestOptions = RequestOptions()
                .placeholder(R.drawable.ic_baseline_photo)
                .centerCrop()
            Glide.with(activity)
                .load(imageNew)
                .transition(DrawableTransitionOptions.withCrossFade())
                .thumbnail(
                    Glide.with(activity)
                        .load(imageNew)
                        .apply(requestOption)
                )
                .apply(requestOption)
                .into(ivPhoto!!)
        } catch (e: Exception) {
            Glide.with(activity)
                .load(ContextCompat.getDrawable(activity, R.drawable.ic_broken_image_black))
                .into(ivPhoto!!)
            e.printStackTrace()
        }
    }
}