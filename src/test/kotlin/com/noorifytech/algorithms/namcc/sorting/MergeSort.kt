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

        var i = 0
        var j = 0
        var k = start

        while (i < leftArr.size && j < rightArr.size) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i]
                i++
            } else {
                arr[k] = rightArr[j]
                j++
            }

            k++
        }

        while (i < leftArr.size) {
            arr[k] = leftArr[i]
            i++
            k++
        }

        while (j < rightArr.size) {
            arr[k] = rightArr[j]
            j++
            k++
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