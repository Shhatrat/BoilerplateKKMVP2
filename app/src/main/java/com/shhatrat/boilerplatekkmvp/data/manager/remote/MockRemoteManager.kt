package com.shhatrat.boilerplatekkmvp.data.manager.remote

import com.shhatrat.boilerplatekkmvp.data.model.Joke
import com.shhatrat.boilerplatekkmvp.data.model.ResponseWrapper
import com.shhatrat.boilerplatekkmvp.util.MockUtil
import io.reactivex.Single

class MockRemoteManager : IRemoteManager {

    override fun getRandomJoke(): Single<ResponseWrapper<Joke>> {
        return Single.just(MockUtil.getWrappedJoke())
    }
}