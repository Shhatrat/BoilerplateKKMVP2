package com.shhatrat.boilerplatekkmvp.data.manager.db

import com.shhatrat.boilerplatekkmvp.data.model.Joke
import com.shhatrat.boilerplatekkmvp.util.MockUtil
import io.reactivex.Completable
import io.reactivex.Observable

class MockDatabaseImpl : IDatabaseManager {

    override fun addJoke(joke: Joke): Completable {
        return Completable.complete()
    }

    override fun getJokes(): Observable<Joke> {
        return Observable.just(MockUtil.getWrappedJokeFromDb().value)
    }
}