package com.shhatrat.boilerplatekkmvp.di.module

import com.shhatrat.boilerplatekkmvp.di.InjectionType
import com.shhatrat.boilerplatekkmvp.ui.joke.JokePresenterImpl
import com.shhatrat.boilerplatekkmvp.ui.joke.MockJokePresenterImpl
import com.shhatrat.boilerplatekkmvp.ui.joke.IJokeContract
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun  getPresenterModule() = module {
    factory<IJokeContract.P>(named(InjectionType.BETA.name)) { JokePresenterImpl(get()) }
    factory<IJokeContract.P>(named(InjectionType.MOCK.name)) { MockJokePresenterImpl() }
    factory<IJokeContract.P>(named(InjectionType.PROD.name)) { JokePresenterImpl(get()) }
}
