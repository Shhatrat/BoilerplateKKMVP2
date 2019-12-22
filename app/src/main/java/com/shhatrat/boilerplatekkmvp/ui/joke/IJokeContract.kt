package com.shhatrat.boilerplatekkmvp.ui.joke

import com.shhatrat.boilerplatekkmvp.base.IPresenter
import com.shhatrat.boilerplatekkmvp.base.IView

interface IJokeContract{
    interface V: IView{
        fun showJokeText(joke: String)
        fun onSaveJokeClicked(action: () -> Unit)
        fun onShowNewJoke(action: () -> Unit)
        fun onShowSavedJoke(action: () -> Unit)
    }
    interface P: IPresenter<V>
}