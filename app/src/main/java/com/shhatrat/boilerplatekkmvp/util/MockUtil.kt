package com.shhatrat.boilerplatekkmvp.util

import com.shhatrat.boilerplatekkmvp.data.model.Joke
import com.shhatrat.boilerplatekkmvp.data.model.ResponseWrapper

object MockUtil {

    fun getWrappedJoke(): ResponseWrapper<Joke> {
        return ResponseWrapper<Joke>("success", Joke(1, "mock joke"))
    }

    fun getWrappedJokeFromDb(): ResponseWrapper<Joke> {
        return ResponseWrapper<Joke>("success", Joke(1, "mock db joke"))
    }
}