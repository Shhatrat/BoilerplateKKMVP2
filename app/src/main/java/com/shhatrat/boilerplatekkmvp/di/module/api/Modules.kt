package com.shhatrat.boilerplatekkmvp.di.module.api

import com.shhatrat.boilerplatekkmvp.di.module.common.getPresenterModule
import com.shhatrat.boilerplatekkmvp.di.module.mock.getManagerModule

fun getApiModuleList() = listOf(
    getPresenterModule(),
    getApiManagerModule(),
    getRemoteManagerModule(),
    getApiDatabaseModule()
)