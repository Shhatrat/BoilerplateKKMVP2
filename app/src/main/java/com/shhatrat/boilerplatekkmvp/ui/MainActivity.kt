package com.shhatrat.boilerplatekkmvp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shhatrat.boilerplatekkmvp.R
import com.shhatrat.boilerplatekkmvp.ui.joke.JokeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, JokeActivity::class.java))
    }
}
