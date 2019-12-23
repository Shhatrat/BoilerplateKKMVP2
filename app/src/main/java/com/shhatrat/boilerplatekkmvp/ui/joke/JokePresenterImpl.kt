package com.shhatrat.boilerplatekkmvp.ui.joke

import com.shhatrat.boilerplatekkmvp.base.BasePresenter
import com.shhatrat.boilerplatekkmvp.data.manager.joke.IJokeManager
import com.shhatrat.boilerplatekkmvp.data.model.Joke
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class JokePresenterImpl
constructor(private val jokeManager: IJokeManager) : BasePresenter<IJokeContract.V>(),
    IJokeContract.P {

    private var currentJoke: Joke? = null

    override fun viewPrepared() {
        super.viewPrepared()
        setupAndroidViewListener()
        downloadJoke()
    }

    private fun downloadJoke() {
        jokeManager.getJokeFromWeb()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                currentJoke = it
                showCurrentJoke()
            }, {}).addTo(subscriptions)
    }

    private fun showCurrentJoke() {
        currentJoke?.joke?.let { it1 -> androidView?.showJokeText(it1) }
    }

    private fun saveJokeClicked() {
        currentJoke?.let { jokeManager.saveJokeToDb(it) }
    }

    private fun showSavedJoke() {
        currentJoke?.let {
            jokeManager.getJokeFromDb()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    currentJoke = it
                    currentJoke?.joke?.let { it1 -> androidView?.showJokeText(it1) }
                }, {}
                ).addTo(subscriptions)
        }
    }

    private fun setupAndroidViewListener() {
        androidView?.onSaveJokeClicked { saveJokeClicked() }
        androidView?.onShowNewJoke { downloadJoke() }
        androidView?.onShowSavedJoke { showSavedJoke() }
    }
}