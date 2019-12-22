package com.shhatrat.boilerplatekkmvp.util

import com.shhatrat.boilerplatekkmvp.data.model.Joke
import com.shhatrat.boilerplatekkmvp.data.model.ResponseWrapper
import okhttp3.Response

object MockUtil{

    fun getWrappedJoke(): ResponseWrapper<Joke>{
        return ResponseWrapper<Joke>("success", Joke(1, "mock joke"))
    }
}