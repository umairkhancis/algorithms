package com.noorifytech.algorithms.namcc.sorting

import org.junit.Test

class MergeSort {
    private fun mergeSort(arr: IntArray) {
        mergeSort(arr, 0, arr.size - 1)
    }

    private fun mergeSort(arr: IntArray, start: Int, end: Int) {
        if (start == end) {
            return
        }

        val mid = (start + end) / 2

        mergeSort(arr, start, mid)
        mergeSort(arr, mid + 1, end)

        merge(arr, start, mid, end)
    }

    private fun merge(arr: IntArray, start: Int, mid: Int, end: Int) {
        val leftArr = arr.slice(start..mid).toIntArray()
        val rightArr = arr.slice((mid + 1)..end).toIntArray()

        var leftIndex = 0
        var rightIndex = 0
        var originalIndex = start

        while (leftIndex < leftArr.size && rightIndex < rightArr.size) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                arr[originalIndex] = leftArr[leftIndex]
                leftIndex++
            } else {
                arr[originalIndex] = rightArr[rightIndex]
                rightIndex++
            }

            originalIndex++
        }

        while (leftIndex < leftArr.size) {
            arr[originalIndex] = leftArr[leftIndex]
            leftIndex++
            originalIndex++
        }

        while (rightIndex < rightArr.size) {
            arr[originalIndex] = rightArr[rightIndex]
            rightIndex++
            originalIndex++
        }
    }

    @Test
    fun mergeSort_case1() {
        val arr = intArrayOf(4, 2, 9, 5, 3, 1, 8, 6)
        mergeSort(arr)
        println("sorted array = ${arr.toList()}")
    }

    @Test
    fun mergeSort_case2() {
        val arr = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
        mergeSort(arr)
        println("sorted array = ${arr.toList()}")
    }
}