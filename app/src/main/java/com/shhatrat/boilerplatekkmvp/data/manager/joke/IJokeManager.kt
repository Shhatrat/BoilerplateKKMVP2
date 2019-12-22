package com.shhatrat.boilerplatekkmvp.data.manager.joke

import com.shhatrat.boilerplatekkmvp.data.model.Joke
import io.reactivex.Single

interface IJokeManager{

    fun getJokeFromWeb(): Single<Joke>
}