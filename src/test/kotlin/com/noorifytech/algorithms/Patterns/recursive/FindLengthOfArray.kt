package com.noorifytech.algorithms.Patterns.recursive

import org.junit.Assert
import org.junit.Test

class FindLengthOfArray {
    private fun findLengthOfArray(arr: IntArray): Int {
        if(arr.isEmpty()) {
            return 0
        }

        return 1 + findLengthOfArray(arr.sliceArray(1..arr.lastIndex))
    }

    @Test
    fun findLengthOfArray_() {
        // Arrange
        val arr = intArrayOf(1, 3, 4, 12, 6, 11)

        // Act
        val result = findLengthOfArray(arr)
        println("arrayLength = $result")

        // Assert
        Assert.assertEquals(6, result)
    }
}