package com.noorifytech.algorithms.namcc.recursion

import org.junit.After
import org.junit.Assert
import org.junit.Test

class Power {

    private fun power_bruteforce(base: Double, p: Int): Double {
        if (p == 0) return 1.0

        println("${++steps}")
        return base * power_bruteforce(base, p - 1)
    }

    private fun power_optimized(base: Double, exp: Int): Double {
        if (exp == 0) return 1.0

        println("${++steps}")
        return if (exp % 2 == 0) {
            val temp = power_optimized(base, exp / 2)
            temp * temp
        } else {
            val temp = power_optimized(base, exp - 1)
            temp * base
        }
    }

    @Test
    fun power_bruteforce_case1() {
        Assert.assertEquals(9.0, power_bruteforce(3.0, 2), 0.0)
    }

    /**
     * Brute force approach takes 40 steps to compute power(2, 40) => O(n)
     */
    @Test
    fun power_bruteforce_case3() {
        Assert.assertEquals(1099511627776.0, power_bruteforce(2.0, 40), 0.0)
    }

    /**
     * Optimized approach takes 7 steps to compute power(2, 40) => O(logn)
     */
    @Test
    fun power_optimized_case4() {
        Assert.assertEquals(1099511627776.0, power_optimized(2.0, 40), 0.0)
    }

    @After
    fun tearDown() {
        steps = 0
    }

    companion object {
        var steps: Int = 0
    }
}