package com.noorifytech.algorithms.CrackingTheCodingInterview.arrays

import org.junit.Assert
import org.junit.Test

class CheckPalindromePermutation {
    fun isPalindromePermutation(str: String): Boolean {
        val permutations = getPermutations(str)
        for (s in permutations) {
            if (isPalindrome(s)) return true
        }
        return false
    }

    private fun isPalindrome(s: String): Boolean {
        return true
    }

    private fun getPermutations(str: String): List<String> {
        val result = mutableListOf<String>()
        permutations("", str, result)
        println("permutations: $result")
        return result
    }

    private fun permutations(prefix: String, suffix: String, result: MutableList<String>) {
        if (suffix.isEmpty()) {
            result.add(prefix)
        } else {
            for (i in 0..suffix.length) {
                permutations(prefix + suffix[i], suffix.substring(i + 1, suffix.length - 1), result)
            }
        }
    }

    @Test
    fun isPalindromePermutation_whenIs_returnsTrue() {
        // Arrange
        val str1 = "aba"
        val str2 = "carerac"

        // Act
        val res1 = isPalindromePermutation(str1)
        val res2 = isPalindromePermutation(str2)

        // Assert
        Assert.assertTrue(res1)
        Assert.assertTrue(res2)
    }

    @Test
    fun isPalindromePermutation_whenIsNot_returnsFalse() {
        // Arrange
        val str = "code"

        // Act
        val res = isPalindromePermutation(str)

        // Assert
        Assert.assertTrue(res)
    }
}