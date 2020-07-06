package com.noorifytech.algorithms.patterns.codingbat.recursion1

import org.junit.Assert
import org.junit.Test

/**
 *
Given n of 1 or more, return the factorial of n,
which is n * (n-1) * (n-2) ... 1.
Compute the result recursively (without loops).

factorial(1) → 1
factorial(2) → 2
factorial(3) → 6
 */
    class Factorial {
    private fun factorial(n: Int): Int {
        return if (n == 0 || n == 1) {
            1
        } else {
            n * factorial(n - 1)
        }
    }

    @Test
    fun factorial_1() {
        // Arrange
        val input = 1

        // Act
        val result = factorial(input)

        // Assert
        Assert.assertEquals(1, result)
    }

    @Test
    fun factorial_2() {
        // Arrange
        val input = 2

        // Act
        val result = factorial(input)

        // Assert
        Assert.assertEquals(2, result)
    }

    @Test
    fun factorial_3() {
        // Arrange
        val input = 3

        // Act
        val result = factorial(input)

        // Assert
        Assert.assertEquals(6, result)
    }

    @Test
    fun factorial_4() {
        // Arrange
        val input = 4

        // Act
        val result = factorial(input)

        // Assert
        Assert.assertEquals(24, result)
    }

    @Test
    fun factorial_5() {
        // Arrange
        val input = 5

        // Act
        val result = factorial(input)

        // Assert
        Assert.assertEquals(120, result)
    }

    @Test
    fun factorial_6() {
        // Arrange
        val input = 6

        // Act
        val result = factorial(input)

        // Assert
        Assert.assertEquals(720, result)
    }

    @Test
    fun factorial_7() {
        // Arrange
        val input = 7

        // Act
        val result = factorial(input)

        // Assert
        Assert.assertEquals(5040, result)
    }

    @Test
    fun factorial_8() {
        // Arrange
        val input = 8

        // Act
        val result = factorial(input)

        // Assert
        Assert.assertEquals(40320, result)
    }

    @Test
    fun factorial_12() {
        // Arrange
        val input = 12

        // Act
        val result = factorial(input)

        // Assert
        Assert.assertEquals(479001600, result)
    }
}