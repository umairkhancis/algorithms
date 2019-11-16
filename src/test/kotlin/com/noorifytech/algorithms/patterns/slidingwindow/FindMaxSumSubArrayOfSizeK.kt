package com.noorifytech.algorithms.patterns.slidingwindow

import org.junit.Assert
import org.junit.Test

class FindMaxSumSubArrayOfSizeK {

    private fun findMaxSumSubArrayOfSizeK(arr: Array<Int>, k: Int): Int {
        var start = 0
        var end = start + k - 1
        val result = arrayOf(start, end)

        // validation
        if (end >= arr.size) {
            throw IllegalArgumentException("Input array is not of appropriate size.")
        }

        var currentSum = arr.sliceArray(start..end).sum() // sum of 1st window
        var currentMaxSum = currentSum // set first sum as max sum for baseline
        end++ // update end for next window
        while (end < arr.size) {
            currentSum += arr[end] - arr[start]

            if (currentSum > currentMaxSum) {
                currentMaxSum = currentSum
                result[0] = start
                result[1] = end
            }

            start++
            end++
        }

        return currentMaxSum
    }

    @Test
    fun test_1() {
        // Arrange
        val expectedResult = 700
        val inputArray = arrayOf(100, 200, 300, 400)
        val k = 2

        // Act
        val actualResult = findMaxSumSubArrayOfSizeK(inputArray, k)

        // Assert
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun test_2() {
        // Arrange
        val expectedResult = 39
        val inputArray = arrayOf(1, 4, 2, 10, 23, 3, 1, 0, 20)
        val k = 4

        // Act
        val actualResult = findMaxSumSubArrayOfSizeK(inputArray, k)

        // Assert
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_3() {
        // Arrange
        val inputArray = emptyArray<Int>()

        // Act
        val actualResult = findMaxSumSubArrayOfSizeK(inputArray, k = 2)

        // Assert
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_4() {
        // Arrange
        val inputArray = arrayOf(1)

        // Act
        val actualResult = findMaxSumSubArrayOfSizeK(inputArray, k = 2)

        // Assert
    }
}