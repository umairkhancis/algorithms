package com.noorifytech.algorithms.noorifytech

import org.junit.Assert
import org.junit.Test

class GroupSum {
    private fun isSumExist(arr: Array<Int>, sum: Int): Boolean {
        return solve(arr, 0, sum)
    }

    private fun solve(arr: Array<Int>, index: Int, sum: Int): Boolean {
        if (index == arr.size) {
            println("${sum == 0}")
            return sum == 0
        }

        return solve(arr, index + 1, sum) || solve(arr, index + 1, sum - arr[index])
    }

    @Test
    fun case1() {
        Assert.assertTrue(isSumExist(arrayOf(1, 3, 5, 2, 9), 10))
    }
}