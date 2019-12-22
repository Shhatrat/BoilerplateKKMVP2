package com.shhatrat.boilerplatekkmvp

import android.app.Application
import com.shhatrat.boilerplatekkmvp.di.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BoilerplateKkmvpApp: Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BoilerplateKkmvpApp)
            modules(getModuleList())
        }
    }
}