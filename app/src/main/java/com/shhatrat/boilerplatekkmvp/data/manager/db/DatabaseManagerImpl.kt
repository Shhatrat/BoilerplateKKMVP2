package com.shhatrat.boilerplatekkmvp.data.manager.db

import com.shhatrat.boilerplatekkmvp.data.db.JokeDb
import com.shhatrat.boilerplatekkmvp.data.db.model.JokeTable
import com.shhatrat.boilerplatekkmvp.data.model.Joke
import io.reactivex.Completable
import io.reactivex.Observable

class DatabaseManagerImpl
constructor(private val jokeDb: JokeDb) : IDatabaseManager {

    override fun addJoke(joke: Joke): Completable {
        return jokeDb.jokeDao().insert(JokeTable(joke.id, joke.joke))
    }

    override fun getJokes(): Observable<Joke> {
        return jokeDb.jokeDao().getJoke().flatMapIterable { list -> list }
            .map { it -> Joke(it.id, it.joke) }
    }
}