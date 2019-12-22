package com.shhatrat.boilerplatekkmvp.data.model

data class ResponseWrapper<T: Any>(
    val type: String,
    val value: T
)