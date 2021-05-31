package com

import android.app.Application
import com.utils.Prefs

class TestKotlinApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val prefs = Prefs(this)
        prefs.init(this)
    }

}