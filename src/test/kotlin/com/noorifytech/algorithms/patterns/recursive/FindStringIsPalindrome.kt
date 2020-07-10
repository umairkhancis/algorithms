package com.noorifytech.algorithms.patterns.recursive

import org.junit.Assert
import org.junit.Test

class FindStringIsPalindrome {

    private fun isPalindrome(str: String): Boolean {
        if (str.length <= 1) {
            return true
        }

        val isLastPalindrome = isPalindrome(str.slice(1 until str.length - 1))
        return isLastPalindrome && str[0] == str[str.length - 1]
    }

    @Test
    fun isPalindrome_case1() {
        // Arrange
        val str = "12344321"

        // Act
        val result = isPalindrome(str)

        // Assert
        Assert.assertTrue(result)
    }

    @Test
    fun isPalindrome_case2() {
        // Arrange
        val str = "racecar"

        // Act
        val result = isPalindrome(str)

        // Assert
        Assert.assertTrue(result)
    }
}