package com

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.testKotlin.R
import com.testKotlin.view.ListActivity
import com.testKotlin.view.LoginActivity
import com.utils.Prefs

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DISPLAY_LENGTH = 2000
    var mainIntent : Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        if(Prefs.getInstance().getString("token").equals("")){
            mainIntent = Intent(this, LoginActivity::class.java)
            switchScreenfirst()
        }else{
            mainIntent = Intent(this, ListActivity::class.java)
        }
    }


    private fun switchScreenfirst() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(mainIntent)
            finishAffinity()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}