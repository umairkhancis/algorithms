package com.noorifytech.algorithms.patterns.recursive

import org.junit.Assert
import org.junit.Test

class SortArray {

    private fun sort(arr: IntArray): IntArray {
        return sort_(arr.toList() as ArrayList<Int>).toIntArray()
    }

    private fun sort_(arr: ArrayList<Int>): ArrayList<Int> {
        if (arr.size <= 1) {
            return arr
        }

        val last = arr[arr.size - 1]
        arr.removeAt(arr.size - 1)
        sort_(arr)
        insert(arr, last)

        return arr
    }

    private fun insert(arr: ArrayList<Int>, value: Int) {
        if (arr.isEmpty() || value >= arr[arr.size - 1]) {
            arr.add(value)
            return
        }

        val last = arr[arr.size - 1]
        arr.removeAt(arr.size - 1)
        insert(arr, value)
        arr.add(last)
    }

    @Test
    fun sortArray_case1() {
        // Arrange
        val arr = intArrayOf(1, 5, 3, 7, 2, 9, 0)

        // Act
        val sortedArray = sort(arr)

        // Assert
        Assert.assertEquals(sortedArray.toList(), intArrayOf(0, 1, 2, 3, 5, 7, 9).toList())
    }
}