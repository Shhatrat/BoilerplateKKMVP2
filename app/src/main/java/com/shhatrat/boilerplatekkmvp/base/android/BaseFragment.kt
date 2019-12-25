package com.shhatrat.boilerplatekkmvp.base.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shhatrat.boilerplatekkmvp.base.BaseInjectionView
import com.shhatrat.boilerplatekkmvp.base.BasePresenter.Companion.DATA_KEY
import com.shhatrat.boilerplatekkmvp.base.IPresenter
import com.shhatrat.boilerplatekkmvp.base.IView

abstract class BaseFragment<PresenterType : IPresenter<ViewType>, ViewType : IView>
    : Fragment(),
    BaseInjectionView<PresenterType, ViewType> {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = super.onCreateView(inflater, container, savedInstanceState)
        attach(arguments?.getString(DATA_KEY))
        return v
    }

    override fun onDestroyView() {
        super.onDestroyView()
        detach()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }
}