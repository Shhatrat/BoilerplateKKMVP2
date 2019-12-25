package com.shhatrat.boilerplatekkmvp

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class TestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, BoilerpateKkmvpTestApp::class.java.name, context)
    }
}