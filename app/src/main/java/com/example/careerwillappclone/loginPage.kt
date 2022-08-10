package com.example.careerwillappclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.careerwillappclone.R
import android.content.SharedPreferences
import com.example.careerwillappclone.loginPage
import android.content.Intent
import android.widget.Button
import com.example.careerwillappclone.MainActivity

class loginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        val login = findViewById<Button>(R.id.loginbutton)
        login.setOnClickListener {
            val sharedPreferences = getSharedPreferences(PREFS_NAME, 0)
            val editor = sharedPreferences.edit()
            editor.putBoolean("hasLoggedIn", true)
            editor.apply()
            startActivity(Intent(this@loginPage, MainActivity::class.java))
            finish()
        }
    }

    companion object {
        @JvmField
        var PREFS_NAME = "MyPrefsFile"
    }
}