package com.shhatrat.boilerplatekkmvp.di.module.api

import com.shhatrat.boilerplatekkmvp.data.manager.db.DatabaseManagerImpl
import com.shhatrat.boilerplatekkmvp.data.manager.db.IDatabaseManager
import com.shhatrat.boilerplatekkmvp.data.manager.joke.IJokeManager
import com.shhatrat.boilerplatekkmvp.data.manager.joke.JokeManagerImpl
import com.shhatrat.boilerplatekkmvp.data.manager.remote.IRemoteManager
import com.shhatrat.boilerplatekkmvp.data.manager.remote.RemoteManagerImpl
import org.koin.dsl.module

fun getApiManagerModule() = module {
    single<IRemoteManager> { RemoteManagerImpl(get()) }
    single<IDatabaseManager> { DatabaseManagerImpl(get()) }
    single<IJokeManager> { JokeManagerImpl(get(), get()) }
}