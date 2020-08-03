package com.noorifytech.algorithms.namcc.sorting

import org.junit.Assert
import org.junit.Test

class FindDuplicatesInTwoSortedArray {
    private fun findDuplicates(arr1: IntArray, arr2: IntArray): List<Int> {
        val res = mutableListOf<Int>()
        var i = 0
        var j = 0

        while (i < arr1.size && j < arr2.size) {
            if (arr1[i] == arr2[j]) {
                res.add(arr1[i])
                i++
                j++
            } else if (arr1[i] < arr2[j]) {
                i++
            } else if (arr1[i] > arr2[j]) {
                j++
            }
        }

        return res
    }

    @Test
    fun findDuplicates_case1() {
        Assert.assertEquals(
            intArrayOf(2, 4, 8).toList(),
            findDuplicates(intArrayOf(2, 4, 6, 8, 10), intArrayOf(1, 2, 3, 4, 8, 20))
        )
    }
}