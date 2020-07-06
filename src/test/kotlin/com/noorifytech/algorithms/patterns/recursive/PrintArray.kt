package com.noorifytech.algorithms.patterns.recursive

import org.junit.Test

class PrintArray {
    private fun printArray(arr: IntArray) {
        if(arr.isEmpty()) {
            return
        }
        print("${arr[0]} ")
        printArray(arr.sliceArray(1 until arr.size))
    }

    @Test
    fun printArray_() {
        // Arrange
        val arr = intArrayOf(1, 3, 4, 12, 6, 11)

        // Act
        printArray(arr)

        // Assert
//        Assert.assertEquals(6, result)
    }
}