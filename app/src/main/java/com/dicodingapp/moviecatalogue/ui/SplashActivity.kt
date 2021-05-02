package com.dicodingapp.moviecatalogue.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicodingapp.moviecatalogue.BuildConfig
import com.dicodingapp.moviecatalogue.R
import com.dicodingapp.moviecatalogue.databinding.ActivitySplashBinding
import com.dicodingapp.moviecatalogue.ui.home.HomeActivity
import com.dicodingapp.moviecatalogue.utils.DefineUI

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(activitySplashBinding.root)
        DefineUI.changeStatusBarColor(window)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        Handler(Looper.getMainLooper()).postDelayed({
            val homeIntent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(homeIntent)
            finishAffinity()
        }, 3000)

        Glide.with(this).load(R.drawable.ic_baseline_image_100).into(activitySplashBinding.ivLogo)

        activitySplashBinding.tvName.text = getString(R.string.app_name)

        val version = "Version " + BuildConfig.VERSION_NAME
        activitySplashBinding.tvVersion.text = version
    }
}