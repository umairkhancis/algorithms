package com.noorifytech.algorithms.namcc.sorting

import org.junit.Test

class QuickSort {
    private fun quickSort(arr: IntArray) {
        quickSort(arr, 0, arr.size - 1)
    }

    private fun quickSort(arr: IntArray, start: Int, end: Int) {
        if (start >= end) return
        val pivotIndex = partition(arr, 0, end)
        quickSort(arr, start, pivotIndex - 1)
        quickSort(arr, pivotIndex + 1, end)
    }

    private fun partition(arr: IntArray, start: Int, end: Int): Int {
        var pivotIndex = start
        val pivot = arr[end]
        var curr = start
        while (curr <= end) {
            if (arr[curr] < pivot) {
                swap(arr, pivotIndex, curr)
                pivotIndex = curr
            }

            curr++
        }

        return pivotIndex
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    @Test
    fun quickSort_case1() {
        val arr = intArrayOf(4, 2, 9, 5)
        quickSort(arr)
        println("sorted array = ${arr.toList()}")
    }

    @Test
    fun quickSort_case2() {
        val arr = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
        quickSort(arr)
        println("sorted array = ${arr.toList()}")
    }
}