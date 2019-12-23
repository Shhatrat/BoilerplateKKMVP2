package com.shhatrat.boilerplatekkmvp

import android.app.Application
import com.shhatrat.boilerplatekkmvp.di.InjectionType
import com.shhatrat.boilerplatekkmvp.di.module.api.getApiModuleList
import com.shhatrat.boilerplatekkmvp.di.module.mock.getMockModuleList
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BoilerplateKkmvpApp: Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BoilerplateKkmvpApp)
            androidLogger()
            when(InjectionType.valueOf(BuildConfig.INJECTION_TYPE)){
                InjectionType.API -> modules(getApiModuleList())
                InjectionType.MOCK -> modules(getMockModuleList())
            }
        }
    }
}