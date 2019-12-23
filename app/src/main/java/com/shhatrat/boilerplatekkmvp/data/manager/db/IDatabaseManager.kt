package com.shhatrat.boilerplatekkmvp.data.manager.db

import com.shhatrat.boilerplatekkmvp.data.model.Joke
import io.reactivex.Completable
import io.reactivex.Observable

interface IDatabaseManager{

    fun addJoke(joke: Joke): Completable
    fun getJokes(): Observable<Joke>
}