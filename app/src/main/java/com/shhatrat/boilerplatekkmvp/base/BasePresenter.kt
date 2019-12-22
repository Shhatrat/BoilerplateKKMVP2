package com.shhatrat.boilerplatekkmvp.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<ViewType : IView> : IPresenter<ViewType> {

    companion object {
        val DATA_KEY = "DATA_KEY"
    }

    var androidView: ViewType? = null
        get() {
            return field ?: throw MvpViewNotAttachedException()
        }

    val subscriptions = CompositeDisposable()

    override fun attachView(view: ViewType, jsonData: String?) {
        androidView = view
        subscriptions.clear()
        checkDataFromIntent(jsonData)
    }

    override fun detachView() {
        androidView = null
        subscriptions.clear()
    }

    override fun getDataToSend(): String? = null

    override fun viewPrepared() {}

    override fun checkDataFromIntent(jsonData: String?) {}

    override fun isAttached(): Boolean = androidView != null

    class MvpViewNotAttachedException : RuntimeException(
        "Please call Presenter.attachView(IView) before requesting data to the Presenter"
    )
}