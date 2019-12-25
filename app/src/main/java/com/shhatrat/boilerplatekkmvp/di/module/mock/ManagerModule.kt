package com.shhatrat.boilerplatekkmvp.di.module.mock

import com.shhatrat.boilerplatekkmvp.data.manager.db.IDatabaseManager
import com.shhatrat.boilerplatekkmvp.data.manager.db.MockDatabaseImpl
import com.shhatrat.boilerplatekkmvp.data.manager.joke.IJokeManager
import com.shhatrat.boilerplatekkmvp.data.manager.joke.JokeManagerImpl
import com.shhatrat.boilerplatekkmvp.data.manager.remote.IRemoteManager
import com.shhatrat.boilerplatekkmvp.data.manager.remote.MockRemoteManager
import org.koin.dsl.module

fun getManagerModule() = module{
    single<IRemoteManager> { MockRemoteManager() }
    single<IDatabaseManager> { MockDatabaseImpl() }
    single<IJokeManager> { JokeManagerImpl(get(),get()) }
}