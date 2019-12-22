package com.shhatrat.boilerplatekkmvp.di.module

import com.shhatrat.boilerplatekkmvp.data.manager.joke.IJokeManager
import com.shhatrat.boilerplatekkmvp.data.manager.joke.JokeManagerImpl
import com.shhatrat.boilerplatekkmvp.data.manager.joke.MockJokeManagerImpl
import com.shhatrat.boilerplatekkmvp.data.manager.remote.IRemoteManager
import com.shhatrat.boilerplatekkmvp.data.manager.remote.MockRemoteManager
import com.shhatrat.boilerplatekkmvp.data.manager.remote.RemoteManagerImpl
import com.shhatrat.boilerplatekkmvp.di.InjectionType
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun getManagerModule() = module{
    single<IRemoteManager>(named(InjectionType.BETA.name)) { RemoteManagerImpl(get()) }
    single<IRemoteManager>(named(InjectionType.MOCK.name)) { MockRemoteManager() }
    single<IRemoteManager>(named(InjectionType.PROD.name)) { RemoteManagerImpl(get()) }
    single<IJokeManager>(named(InjectionType.BETA.name)) { JokeManagerImpl(get()) }
    single<IJokeManager>(named(InjectionType.MOCK.name)) { MockJokeManagerImpl() }
    single<IJokeManager>(named(InjectionType.PROD.name)) { JokeManagerImpl(get()) }
}