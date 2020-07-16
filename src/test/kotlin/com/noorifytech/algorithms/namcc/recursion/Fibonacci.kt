package com.noorifytech.algorithms.namcc.recursion

import org.junit.Assert
import org.junit.Test

class Fibonacci {
    fun fibonacci(n: Int): Int = when {
        n < 2 -> n
        else -> fibonacci(n - 1) + fibonacci(n - 2)
    }

    @Test
    fun fibonacci_case1() {
        Assert.assertEquals(1, fibonacci(2))
    }

    @Test
    fun fibonacci_case2() {
        Assert.assertEquals(34, fibonacci(9))
    }

    @Test
    fun fibonacci_case3() {
        Assert.assertEquals(-2, fibonacci(-2))
    }
}