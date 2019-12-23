package com.shhatrat.boilerplatekkmvp.di.module.api

import com.shhatrat.boilerplatekkmvp.data.db.JokeDb
import org.koin.dsl.module

fun getApiDatabaseModule() = module {
    single { JokeDb.getDatabase(get()) }
}
