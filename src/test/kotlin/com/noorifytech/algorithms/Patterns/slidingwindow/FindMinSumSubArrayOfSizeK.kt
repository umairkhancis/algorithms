package com.noorifytech.algorithms.Patterns.slidingwindow

import org.junit.Assert
import org.junit.Test

class FindMinSumSubArrayOfSizeK {

    private fun findMinSumSubArrayOfSizeK(arr: Array<Int>, k: Int): Array<Int> {
        var start = 0
        var end = start + k - 1
        val result = arrayOf(start, end)

        // validation
        if (end >= arr.size) {
            throw IllegalArgumentException("Input array is not of appropriate size.")
        }

        var currentMinSum = arr[start] + arr[end]
        while (end < arr.size) {
            val sum = arr[start] + arr[end]

            if (sum < currentMinSum) {
                currentMinSum = sum
                result[0] = start
                result[1] = end
            }

            start++
            end++
        }

        return result
    }

    @Test
    fun test_1() {
        // Arrange
        val expectedResult = arrayOf(6, 7)
        val inputArray = arrayOf(1, 4, 2, 10, 23, 3, 1, 0, 20)
        val k = 2

        // Act
        val actualResult = findMinSumSubArrayOfSizeK(inputArray, k)

        // Assert
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_2() {
        // Arrange
        val inputArray = emptyArray<Int>()

        // Act
        val actualResult = findMinSumSubArrayOfSizeK(inputArray, k = 2)

        // Assert
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_3() {
        // Arrange
        val inputArray = arrayOf(1)

        // Act
        val actualResult = findMinSumSubArrayOfSizeK(inputArray, k = 2)

        // Assert
    }
}