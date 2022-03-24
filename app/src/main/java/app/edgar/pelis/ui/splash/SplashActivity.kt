package app.edgar.pelis.ui.splash

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.edgar.pelis.R
import app.edgar.pelis.ui.home.MainActivity
import java.util.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            setContentView(R.layout.tmdb_activity_splash)
        }

        Timer().schedule(object : TimerTask(){
            override fun run() {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        }, SPLASH_DELAY)
    }

    companion object {
        private const val SPLASH_DELAY = 1_000L
    }
}