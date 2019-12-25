package com.shhatrat.boilerplatekkmvp.ui.joke

import com.shhatrat.boilerplatekkmvp.R
import com.shhatrat.boilerplatekkmvp.base.android.BaseActivity
import kotlinx.android.synthetic.main.activity_joke.*
import org.koin.android.ext.android.inject

class JokeActivity : BaseActivity<IJokeContract.P, IJokeContract.V>(),
    IJokeContract.V {

    override val presenter: IJokeContract.P by inject()

    override fun getIView(): IJokeContract.V = this

    override fun getLayout(): Int = R.layout.activity_joke

    override fun showJokeText(joke: String) {
        jokeTV.text = joke
    }

    override fun onSaveJokeClicked(action: () -> Unit) {
        saveJokeBtn.setOnClickListener { action.invoke() }
    }

    override fun onShowNewJoke(action: () -> Unit) {
        getNewJokeBtn.setOnClickListener { action.invoke() }
    }

    override fun onShowSavedJoke(action: () -> Unit) {
        getSavedJokeBtn.setOnClickListener { action.invoke() }
    }
}
