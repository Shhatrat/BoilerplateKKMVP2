package com.shhatrat.boilerplatekkmvp.data.manager.joke

import com.shhatrat.boilerplatekkmvp.data.manager.db.IDatabaseManager
import com.shhatrat.boilerplatekkmvp.data.manager.remote.IRemoteManager
import com.shhatrat.boilerplatekkmvp.data.model.Joke
import io.reactivex.Completable
import io.reactivex.Single

class JokeManagerImpl
constructor(
    private val remoteManager: IRemoteManager,
    private val databaseManager: IDatabaseManager
) : IJokeManager {

    override fun getJokeFromDb(): Single<Joke> {
        return databaseManager.getJokes().firstOrError()
    }

    override fun getJokeFromWeb(): Single<Joke> {
        return remoteManager.getRandomJoke().map { it.value }
    }

    override fun saveJokeToDb(joke: Joke): Completable {
        return databaseManager.addJoke(joke)
    }
}