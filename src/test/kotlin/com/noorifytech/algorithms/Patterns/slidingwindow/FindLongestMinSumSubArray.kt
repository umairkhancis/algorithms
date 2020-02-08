package com.noorifytech.algorithms.Patterns.slidingwindow

import org.junit.Assert
import org.junit.Test

class FindLongestMinSumSubArray {

    private fun findLongestMinSumSubArray(arr: Array<Int>): Array<Int> {
        var start = 0
        var end = 1
        val result = arrayOf(start, end)

        // validation
        if(end >= arr.size) {
            throw IllegalArgumentException("Input array is not of appropriate size.")
        }

        var currentMinSum = arr[start] + arr[end]
        while (end < arr.size) {
            val sum = arr[start] + arr[end]

            if (sum < currentMinSum) {
                currentMinSum = sum
                result[0] = start
                result[1] = end
                end++
            } else {
                start = end
                end = start + 1
            }
        }


        return result
    }

    @Test
    fun test_1() {
        // Arrange
        val expectedResult = arrayOf(5, 7)
        val inputArray = arrayOf(1, 4, 2, 10, 23, 3, 1, 0, 20)

        // Act
        val actualResult = findLongestMinSumSubArray(inputArray)

        // Assert
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_2() {
        // Arrange
        val inputArray = emptyArray<Int>()

        // Act
        val actualResult = findLongestMinSumSubArray(inputArray)

        // Assert
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_3() {
        // Arrange
        val inputArray = arrayOf(1)

        // Act
        val actualResult = findLongestMinSumSubArray(inputArray)

        // Assert
    }
}