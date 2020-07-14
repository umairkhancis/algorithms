package com.noorifytech.algorithms.util

import com.google.gson.annotations.SerializedName

data class TestModel<Input, Output>(
    @SerializedName("input")
    val input: Input,

    @SerializedName("output")
    val output: Output
)