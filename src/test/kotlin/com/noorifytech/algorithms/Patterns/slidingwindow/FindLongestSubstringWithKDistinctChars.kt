package com.noorifytech.algorithms.Patterns.slidingwindow

import org.junit.Assert
import org.junit.Test

class FindLongestSubstringWithKDistinctChars {

    private fun findLongestSubstringWithKDistinctChars(input: String, k: Int): Array<Int?> {
        val arr = input.toCharArray()
        var start = 0
        var end = 1
        val result = arrayOfNulls<Int>(2)

        // validation
        if (end >= arr.size) {
            throw IllegalArgumentException("Input array is not of appropriate size.")
        }

        val visitedCharSet = mutableSetOf<Char>()
        var currMaxSSLength = 0
        while (end < arr.size) {
            if (arr[start] !in visitedCharSet) {
                visitedCharSet.add(arr[start])
            }
            if (arr[end] !in visitedCharSet) {
                visitedCharSet.add(arr[end])
            }
            if (visitedCharSet.size > k) {
                visitedCharSet.clear()
                start++
                end = start + 1
            } else {
                val currentSSLength = end - start + 1
                if(currentSSLength > currMaxSSLength) {
                    currMaxSSLength = currentSSLength
                    result[0] = start
                    result[1] = end
                }

                end++
            }
        }

        return result
    }

    @Test
    fun test_2_forK2() {
        // Arrange
        val inputString = "aabbccc"
        val k = 2
        val expectedResult = arrayOf(2, 6)

        // Act
        val actualResult = findLongestSubstringWithKDistinctChars(inputString, k)

        // Assert
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun test_2_forK3() {
        // Arrange
        val inputString = "aabacbebebe"
        val k = 3
        val expectedResult = arrayOf(4, 10)

        // Act
        val actualResult = findLongestSubstringWithKDistinctChars(inputString, k)

        // Assert
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_2() {
        // Arrange
        val inputString = ""
        val k = 2

        // Act
        val actualResult = findLongestSubstringWithKDistinctChars(inputString, k)

        // Assert
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_3() {
        // Arrange
        val inputString = "a"
        val k = 2

        // Act
        val actualResult = findLongestSubstringWithKDistinctChars(inputString, k)

        // Assert
    }
}