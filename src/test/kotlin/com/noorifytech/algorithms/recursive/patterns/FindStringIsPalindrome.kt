package com.noorifytech.algorithms.recursive.patterns

import org.junit.Assert
import org.junit.Test

class FindStringIsPalindrome {
    private fun isPalindrome(str: String): Boolean {
        if (str.length <= 1) {
            return true
        }

        return str[0] == str[str.length - 1] && isPalindrome(str.slice(1 until str.length - 1))
    }

    @Test
    fun isPalindrome_() {
        // Arrange
//        val str = "racecar"
        val str = "12344321"

        // Act
        val result = isPalindrome(str)

        // Assert
        Assert.assertTrue(result)
    }
}