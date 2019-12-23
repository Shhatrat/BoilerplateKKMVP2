package com.shhatrat.boilerplatekkmvp.di.module.mock

import com.shhatrat.boilerplatekkmvp.data.manager.joke.IJokeManager
import com.shhatrat.boilerplatekkmvp.data.manager.joke.MockJokeManagerImpl
import com.shhatrat.boilerplatekkmvp.data.manager.remote.IRemoteManager
import com.shhatrat.boilerplatekkmvp.data.manager.remote.MockRemoteManager
import org.koin.dsl.module

fun getManagerModule() = module{
    single<IRemoteManager> { MockRemoteManager() }
    single<IJokeManager> { MockJokeManagerImpl() }
}