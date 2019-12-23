package com.shhatrat.boilerplatekkmvp.di.module.common

import com.shhatrat.boilerplatekkmvp.ui.joke.IJokeContract
import com.shhatrat.boilerplatekkmvp.ui.joke.JokePresenterImpl
import org.koin.dsl.module

fun  getPresenterModule() = module {
    factory<IJokeContract.P> { JokePresenterImpl(get()) }
}
