package com.shhatrat.boilerplatekkmvp.data.manager.joke

import com.shhatrat.boilerplatekkmvp.data.model.Joke
import io.reactivex.Completable
import io.reactivex.Single

interface IJokeManager {

    fun getJokeFromDb(): Single<Joke>
    fun getJokeFromWeb(): Single<Joke>
    fun saveJokeToDb(joke: Joke): Completable
}