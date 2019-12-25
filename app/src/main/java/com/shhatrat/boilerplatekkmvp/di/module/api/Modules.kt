package com.shhatrat.boilerplatekkmvp.di.module.api

import com.shhatrat.boilerplatekkmvp.di.module.common.getPresenterModule

fun getApiModuleList() = listOf(
    getPresenterModule(),
    getApiManagerModule(),
    getRemoteManagerModule(),
    getApiDatabaseModule()
)