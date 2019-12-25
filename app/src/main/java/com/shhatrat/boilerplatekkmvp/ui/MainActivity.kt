package com.shhatrat.boilerplatekkmvp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shhatrat.boilerplatekkmvp.R
import com.shhatrat.boilerplatekkmvp.ui.joke.JokeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, JokeActivity::class.java))
    }
}
