package com.noorifytech.algorithms.Vezeeta

import org.junit.Assert
import org.junit.Test

class MergeSort {

    private fun mergeSort(arr: Array<Int>): Array<Int> {
        if (arr.size <= 1) {
            return arr
        }

        val midPoint = arr.size / 2
        val firstHalfArr = arr.sliceArray(0 until midPoint)
        val secondHalfArr = arr.sliceArray(midPoint until arr.size)
        return merge(mergeSort(firstHalfArr), mergeSort(secondHalfArr))
    }

    private fun merge(firstHalfArr: Array<Int>, secondHalfArr: Array<Int>): Array<Int> {
        val sortedList = mutableListOf<Int>()
        var i = 0
        var j = 0

        while (i < firstHalfArr.size && j < secondHalfArr.size) {
            if (firstHalfArr[i] <= secondHalfArr[j]) {
                sortedList.add(firstHalfArr[i])
                i++
            } else {
                sortedList.add(secondHalfArr[j])
                j++
            }
        }

        while (i < firstHalfArr.size) {
            sortedList.add(firstHalfArr[i])
            i++
        }

        while (j < secondHalfArr.size) {
            sortedList.add(secondHalfArr[j])
            j++
        }

        return sortedList.toTypedArray()
    }

    @Test
    fun test() {
        // Arrange
        val arr = arrayOf(7, 6, 8, 3, 9, 2, 5, 4)
        val sortedArray = arrayOf(2, 3, 4, 5, 6, 7, 8, 9)

        // Act
        val output = mergeSort(arr)

        // Assert
        Assert.assertArrayEquals(sortedArray, output)
    }
}