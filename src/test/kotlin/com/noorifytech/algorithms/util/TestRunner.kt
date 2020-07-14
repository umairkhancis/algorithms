package com.noorifytech.algorithms.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.Assert
import java.lang.reflect.Type
import java.nio.file.Files
import java.nio.file.Paths

fun <INPUT, OUTPUT> runAllTests(fileName: String, execution: (INPUT) -> OUTPUT) {
    val json: String? = readFileAsString(fileName)
    val listType: Type = object : TypeToken<List<TestModel<INPUT, OUTPUT>>>() {}.type
    val tests: List<TestModel<INPUT, OUTPUT>> = Gson().fromJson(json, listType)

    for (i in tests.indices) {
        val test = tests[i]
        println("Running tests ${i + 1}")
        println("Input: ${test.input}")
        println("Output: ${test.output}")

        // Act
        val result = execution(test.input)

        // Assert
        Assert.assertEquals(test.output, result)
    }

    println("Passed all ${tests.size} tests!")
}

@Throws(Exception::class)
fun readFileAsString(file: String?): String? {
    return String(Files.readAllBytes(Paths.get(file)))
}