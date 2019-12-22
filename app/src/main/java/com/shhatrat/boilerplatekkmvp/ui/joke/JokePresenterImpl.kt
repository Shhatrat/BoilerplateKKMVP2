package com.shhatrat.boilerplatekkmvp.ui.joke

import com.shhatrat.boilerplatekkmvp.base.BasePresenter
import com.shhatrat.boilerplatekkmvp.data.manager.joke.IJokeManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class JokePresenterImpl
    constructor(private val jokeManager: IJokeManager): BasePresenter<IJokeContract.V>(), IJokeContract.P{

    override fun viewPrepared() {
        super.viewPrepared()
        setupAndroidViewListener()
        downloadJoke()
    }

    private fun downloadJoke(){
        jokeManager.getJokeFromWeb()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            androidView?.showJokeText(it.joke)
        },{}).addTo(subscriptions)
    }

    private fun setupAndroidViewListener(){
        androidView?.onSaveJokeClicked {  }
        androidView?.onShowNewJoke { downloadJoke() }
        androidView?.onShowSavedJoke {  }
    }
}