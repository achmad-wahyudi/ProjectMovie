package com.dicodingapp.moviecatalogue.utils

import android.graphics.Color
import android.os.Build
import android.view.Window
import android.view.WindowManager

object DefineUI {

    fun changeStatusBarColor(window: Window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }
}