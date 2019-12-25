package com.shhatrat.boilerplatekkmvp.data.manager.remote

import com.shhatrat.boilerplatekkmvp.data.model.Joke
import com.shhatrat.boilerplatekkmvp.data.model.ResponseWrapper
import io.reactivex.Single

interface IRemoteManager {

    fun getRandomJoke(): Single<ResponseWrapper<Joke>>
}