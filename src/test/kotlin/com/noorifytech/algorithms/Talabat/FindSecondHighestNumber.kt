package com.noorifytech.algorithms.Talabat

import org.junit.Assert
import org.junit.Test

/**
 * Given an array of integers, return the second highest element in the array.
 * Example:
 * arr = [5,3,2,7,1,6]
 * secondHighest = 6
 */
class FindSecondHighestNumber {
    private fun findSecondHighestNumber(arr: IntArray): Int {
        if(arr.size < 2) {
            throw IllegalArgumentException("Invalid size array input.")
        }

        var highest = arr[0]
        var secondHighest = Integer.MIN_VALUE + 1

        for (i in 1 until arr.size) {
            if(arr[i] > highest) {
                secondHighest = highest
                highest = arr[i]
            } else if (arr[i] > secondHighest) {
                secondHighest = arr[i]
            }
        }

        return secondHighest
    }

    @Test
    fun findSecondHighestNumber_() {
        // Arrange
        val arr = intArrayOf(1, 3, 4, 12, 6, 11)

        // Act
        val result = findSecondHighestNumber(arr)
        println("secondHighest = $result")

        // Assert
        Assert.assertEquals(11, result)
    }
}