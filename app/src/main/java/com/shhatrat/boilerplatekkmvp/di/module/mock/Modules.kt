package com.shhatrat.boilerplatekkmvp.di.module.mock

import com.shhatrat.boilerplatekkmvp.di.module.common.getPresenterModule

fun getMockModuleList() = listOf(
    getPresenterModule(),
    getManagerModule()
)