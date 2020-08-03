package com.noorifytech.algorithms.namcc.doublepointers

import org.junit.Assert
import org.junit.Test
import java.util.*

class TwoSumProblemInSortedArray {

    private fun isPairExistsInSortedArray(arr: IntArray, k: Int): Boolean {
        var start = 0
        var end = arr.size - 1

        while (end > start) {
            val sum = arr[start] + arr[end]
            when {
                sum > k -> end--
                sum < k -> start++
                else -> return true
            }
        }

        return false
    }

    @Test
    fun isPairExistsInSortedArray_case1() {
        val arr = intArrayOf()
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 0))
    }

    @Test
    fun isPairExistsInSortedArray_case2() {
        val arr = intArrayOf()
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 5))
    }

    @Test
    fun isPairExistsInSortedArray_case3() {
        val arr = intArrayOf(4)
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 4))
    }

    @Test
    fun isPairExistsInSortedArray_case4() {
        val arr = intArrayOf(4)
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 5))
    }

    @Test
    fun isPairExistsInSortedArray_case5() {
        val arr = intArrayOf(4)
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 0))
    }

    @Test
    fun isPairExistsInSortedArray_case6() {
        val arr = intArrayOf(6, 4)
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 6))
    }

    @Test
    fun isPairExistsInSortedArray_case7() {
        val arr = intArrayOf(6, 4)
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 5))
    }

    @Test
    fun isPairExistsInSortedArray_case8() {
        val arr = intArrayOf(6, 0, 4)
        Arrays.sort(arr)
        Assert.assertTrue(isPairExistsInSortedArray(arr, 6))
    }

    @Test
    fun isPairExistsInSortedArray_case9() {
        val arr = intArrayOf(8, 1, 6, 20, -3)
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 6))
    }

    @Test
    fun isPairExistsInSortedArray_case10() {
        val arr = intArrayOf(8, 1, 6, -6, -3)
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 6))
    }

    @Test
    fun isPairExistsInSortedArray_case11() {
        val arr = intArrayOf(8, 1, 6, 6, 4)
        Arrays.sort(arr)
        Assert.assertTrue(isPairExistsInSortedArray(arr, 12))
    }

    @Test
    fun isPairExistsInSortedArray_case12() {
        val arr = intArrayOf(8, 1, 6, 6, 4)
        Arrays.sort(arr)
        Assert.assertTrue(isPairExistsInSortedArray(arr, 12))
    }

    @Test
    fun isPairExistsInSortedArray_case13() {
        val arr = intArrayOf(3, 3, 3, 4, 2, 4, 2, 5, 1)
        Arrays.sort(arr)
        Assert.assertTrue(isPairExistsInSortedArray(arr, 7))
    }

    @Test
    fun isPairExistsInSortedArray_case14() {
        val arr = intArrayOf(3, 1, 6, 4, 2, -1)
        Arrays.sort(arr)
        Assert.assertTrue(isPairExistsInSortedArray(arr, 5))
    }

    @Test
    fun isPairExistsInSortedArray_case15() {
        val arr = intArrayOf(3, 5, 20, 4, -3)
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 5))
    }

    @Test
    fun isPairExistsInSortedArray_case16() {
        val arr = intArrayOf(8, 1, 6, 4, -3)
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 0))
    }

    @Test
    fun isPairExistsInSortedArray_case17() {
        val arr = intArrayOf(8, 1, 6, 4, -3)
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 0))
    }

    @Test
    fun isPairExistsInSortedArray_case18() {
        val arr = intArrayOf(8, 1, 6, 4, -3)
        Arrays.sort(arr)
        Assert.assertFalse(isPairExistsInSortedArray(arr, 0))
    }

    @Test
    fun isPairExistsInSortedArray_case19() {
        val arr = intArrayOf(8, 1, 6, 4, -3)
        Arrays.sort(arr)
        Assert.assertTrue(isPairExistsInSortedArray(arr, 7))
    }

    @Test
    fun isPairExistsInSortedArray_case20() {
        val arr = intArrayOf(8, 1, 6, 4, -3)
        Arrays.sort(arr)
        Assert.assertTrue(isPairExistsInSortedArray(arr, 1))
    }

    @Test
    fun isPairExistsInSortedArray_case21() {
        val arr = intArrayOf(8, 1, 6, 4, -3)
        Arrays.sort(arr)
        Assert.assertFalse(
            isPairExistsInSortedArray(arr, Math.pow(10.toDouble(), 5.toDouble()).toInt())
        )
    }

    @Test
    fun isPairExistsInSortedArray_case22() {
        val arr = intArrayOf(
            8,
            1,
            6,
            4,
            -3,
            8,
            1,
            6,
            4,
            1,
            6,
            4,
            -3,
            8,
            1,
            192,
            -80,
            -30
        )
        Arrays.sort(arr)
        Assert.assertTrue(
            isPairExistsInSortedArray(
                arr, 200
            )
        )
    }

    @Test
    fun isPairExistsInSortedArray_case23() {
        val arr = intArrayOf(
            8,
            1,
            6,
            4,
            -3,
            8,
            1,
            6,
            4,
            1,
            6,
            400,
            600,
            8,
            1,
            192,
            -80,
            -30
        )
        Arrays.sort(arr)
        Assert.assertTrue(
            isPairExistsInSortedArray(arr, 200)
        )
    }

    @Test
    fun isPairExists_optimized_case24() {
        Assert.assertFalse(isPairExistsInSortedArray(intArrayOf(6, 4, 7, 200), 14))
    }
}