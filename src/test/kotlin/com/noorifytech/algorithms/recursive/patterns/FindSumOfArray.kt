package com.noorifytech.algorithms.recursive.patterns

import org.junit.Assert
import org.junit.Test

class FindSumOfArray {
    private fun findSumOfArray(arr: IntArray): Int {
        if(arr.isEmpty()) {
            return 0
        }

        return arr[0] + findSumOfArray(arr.sliceArray(1..arr.lastIndex))
    }

    @Test
    fun findSumOfArray_1() {
        // Arrange
        val arr = intArrayOf(1, 3, 4, 12, 6, 11)

        // Act
        val result = findSumOfArray(arr)
        println("arraySum = $result")

        // Assert
        Assert.assertEquals(37, result)
    }

    @Test
    fun findSumOfArray_2() {
        // Arrange
        val arr = intArrayOf(1, 2, 3, 4, 5, 6)

        // Act
        val result = findSumOfArray(arr)
        println("arraySum = $result")

        // Assert
        Assert.assertEquals(21, result)
    }
}