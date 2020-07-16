package com.noorifytech.algorithms.patterns.recursive

import org.junit.Assert
import org.junit.Test

class FindStringIsPalindrome {

    private fun isPalindrome(str: String): Boolean {
        return isPalindrome(str, start = 0, end = str.length - 1)
    }

    private fun isPalindrome(str: String, start: Int, end: Int): Boolean = when {
        start <= end -> str[start] == str[end]
        else -> isPalindrome(str, start + 1, end - 1)
    }

    @Test
    fun isPalindrome_case1() {
        // Arrange
        val str = "racecar"

        // Act
        val result = isPalindrome(str)

        // Assert
        Assert.assertTrue(result)
    }

    @Test
    fun isPalindrome_case2() {
        // Arrange
        val str = "abba"

        // Act
        val result = isPalindrome(str)

        // Assert
        Assert.assertTrue(result)
    }

    @Test
    fun isPalindrome_case3() {
        // Arrange
        val str = "a"

        // Act
        val result = isPalindrome(str)

        // Assert
        Assert.assertTrue(result)
    }

    @Test
    fun isPalindrome_case4() {
        // Arrange
        val str = "hello"

        // Act
        val result = isPalindrome(str)

        // Assert
        Assert.assertFalse(result)
    }

    @Test
    fun isPalindrome_case5() {
        // Arrange
        val str = "ax"

        // Act
        val result = isPalindrome(str)

        // Assert
        Assert.assertFalse(result)
    }
}