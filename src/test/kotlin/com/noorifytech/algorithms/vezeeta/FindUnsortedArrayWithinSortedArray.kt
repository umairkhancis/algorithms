package com.noorifytech.algorithms.vezeeta

import org.junit.Assert
import org.junit.Test

class FindUnsortedArrayWithinSortedArray {
    @Test
    fun findUnsortedArrayWithinSortedArray_() {
        // Arrange
        val arr = arrayOf(0, 1, 15, 25, 6, 7, 30, 40, 50)
        val pair = Pair(2, 5)

        // Act
        val result = findUnsortedArrayWithinSortedArray(arr)

        // Assert
        Assert.assertEquals(pair, result)
    }

    private fun findUnsortedArrayWithinSortedArray(arr: Array<Int>): Pair<Int, Int> {
        var unsortedStart = -1
        var unsortedEnd = -1

        var startIndex = -1
        var prev = arr[0]
        for (i in 1 until arr.size) {
            if (arr[i] < prev) {
                startIndex = i
                break
            }

            prev = arr[i]
        }

        var endIndex = -1
        prev = arr[arr.size - 1]
        for (i in arr.size - 2 downTo 0) {
            if (arr[i] > prev) {
                endIndex = i
                break
            }

            prev = arr[i]
        }

        val min = arr[startIndex]
        val max = arr[endIndex]
        for (i in 0 until arr.size - 1) {
            if (arr[i] > min) {
                unsortedStart = i
                break
            }
        }

        for (i in arr.size-1 downTo  0) {
            if (arr[i] < max) {
                unsortedEnd = i
                break
            }
        }

        return Pair(unsortedStart, unsortedEnd)
    }
}