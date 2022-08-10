package com.example.careerwillappclone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.careerwillappclone.loginPage
import java.util.*

class splashScreen : AppCompatActivity() {
    private var timer: Timer? = null
    private var progressBar: ProgressBar? = null
    private var i = 0
    var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        progressBar = findViewById(R.id.progressBar)
        progressBar!!.setProgress(0)
        textView = findViewById(R.id.textView)
        textView!!.setText("")
        val period: Long = 30
        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            @SuppressLint("ResourceAsColor")
            override fun run() {
                val sharedPreferences = getSharedPreferences(loginPage.PREFS_NAME, 0)
                val hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn", false)
                //this repeats every 100 ms
                if (i < 80) {
                    runOnUiThread { textView!!.setText("$i%") }
                    progressBar!!.setProgress(i)
                    i++
                } else if (i >= 80 && i < 100) {
                    runOnUiThread {
                        textView!!.setText("Just there !!")
                        textView!!.setTextColor(R.color.teal_200)
                    }
                    progressBar!!.setProgress(i)
                    i++
                } else {
                    //closing the timer
                    timer!!.cancel()
                    if (hasLoggedIn) {
                        val intent = Intent(this@splashScreen, MainActivity::class.java)
                        startActivity(intent)
                        // close this activity
                        finish()
                    } else {
                        val intent = Intent(this@splashScreen, loginPage::class.java)
                        startActivity(intent)
                        // close this activity
                        finish()
                    }
                }
            }
        }, 0, period)
    }
}