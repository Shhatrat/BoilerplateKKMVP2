package com.shhatrat.boilerplatekkmvp.data.manager.joke

import com.shhatrat.boilerplatekkmvp.data.manager.remote.IRemoteManager
import com.shhatrat.boilerplatekkmvp.data.model.Joke
import io.reactivex.Single

class JokeManagerImpl
    constructor(private val remoteManager: IRemoteManager): IJokeManager{

    override fun getJokeFromWeb(): Single<Joke> {
        return remoteManager.getRandomJoke().map { it.value }
    }
}