package com.shhatrat.boilerplatekkmvp.data.manager.remote

import com.shhatrat.boilerplatekkmvp.data.model.Joke
import com.shhatrat.boilerplatekkmvp.data.model.ResponseWrapper
import io.reactivex.Single
import retrofit2.http.GET

class RemoteManagerImpl
    constructor(private val service: Service): IRemoteManager{

    interface Service{
        companion object{
            internal const val URL = "http://api.icndb.com/jokes/"
        }

        @GET("random")
        fun getRandomJoke(
        ): Single<ResponseWrapper<Joke>>
    }

    override fun getRandomJoke(): Single<ResponseWrapper<Joke>> {
        return service.getRandomJoke()
    }
}