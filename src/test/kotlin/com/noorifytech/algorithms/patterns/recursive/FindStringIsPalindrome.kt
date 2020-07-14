package com.noorifytech.algorithms.patterns.recursive

import org.junit.Assert
import org.junit.Test

class FindStringIsPalindrome {

    private fun isPalindrome(str: String): Boolean {
        if (str.length <= 1) return true
        if (str[0] != str[str.length - 1]) return false
        return isPalindrome(str.slice(1 until str.length - 1))
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