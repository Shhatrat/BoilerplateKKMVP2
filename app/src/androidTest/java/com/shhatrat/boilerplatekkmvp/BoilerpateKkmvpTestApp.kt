package com.shhatrat.boilerplatekkmvp

import android.app.Application
import com.shhatrat.boilerplatekkmvp.di.module.mock.getMockModuleList
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BoilerpateKkmvpTestApp: Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BoilerpateKkmvpTestApp)
            androidLogger()
            modules(getMockModuleList())
        }
    }
}