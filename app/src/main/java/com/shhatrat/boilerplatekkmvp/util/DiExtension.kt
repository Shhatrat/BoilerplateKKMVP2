package com.shhatrat.boilerplatekkmvp.util

import android.content.ComponentCallbacks
import com.shhatrat.boilerplatekkmvp.BuildConfig
import org.koin.android.ext.android.getKoin
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.named

inline fun <reified T : Any> ComponentCallbacks.injectWithType(
    noinline parameters: ParametersDefinition? = null
): T = getKoin().get(named(BuildConfig.INJECTION_TYPE), parameters)