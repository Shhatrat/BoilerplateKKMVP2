package com.shhatrat.boilerplatekkmvp.data.manager.joke

import com.shhatrat.boilerplatekkmvp.data.model.Joke
import com.shhatrat.boilerplatekkmvp.util.MockUtil
import io.reactivex.Completable
import io.reactivex.Single

class MockJokeManagerImpl: IJokeManager{

    override fun getJokeFromWeb(): Single<Joke> {
        return Single.just(MockUtil.getWrappedJoke().value)
    }

    override fun getJokeFromDb(): Single<Joke> {
        return Single.just(MockUtil.getWrappedJoke().value)
    }

    override fun saveJokeToDb(joke: Joke): Completable {
        return Completable.complete()
    }
}