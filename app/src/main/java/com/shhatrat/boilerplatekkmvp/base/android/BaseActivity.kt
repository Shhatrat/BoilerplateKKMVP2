package com.shhatrat.boilerplatekkmvp.base.android

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shhatrat.boilerplatekkmvp.base.BaseInjectionView
import com.shhatrat.boilerplatekkmvp.base.BasePresenter.Companion.DATA_KEY
import com.shhatrat.boilerplatekkmvp.base.IPresenter
import com.shhatrat.boilerplatekkmvp.base.IView
import org.jetbrains.anko.internals.AnkoInternals

abstract class BaseActivity<PresenterType : IPresenter<ViewType>, ViewType: IView>
    : AppCompatActivity(),
    BaseInjectionView<PresenterType, ViewType> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        attach(intent.getStringExtra(DATA_KEY))
        prepareView()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        detach()
    }

    inline fun <reified T : Activity>moveToActivity(){
        val param = arrayOf(Pair(DATA_KEY, presenter.getDataToSend()))
        AnkoInternals.internalStartActivity(this, T::class.java, param)
    }
}