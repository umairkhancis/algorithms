package com.noorifytech.algorithms.namcc

import org.junit.Assert
import org.junit.Test
import java.util.*

class TwoSumProblem {

    private fun isPairExistsInUnsortedArray_bruteForce(arr: IntArray, k: Int): Boolean {
        for (i in 0 until arr.size - 1) {
            for (j in (i + 1) until arr.size) {
                if ((arr[i] + arr[j]) == k) return true
            }
        }

        return false
    }

    private fun isPairExistsInUnsortedArray_optimized(arr: IntArray, k: Int): Boolean {
        val set = HashSet<Int>()
        for (element in arr) {
            val complement = k - element
            if (set.contains(element)) {
                return true
            }
            set.add(complement)
        }

        return false
    }

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
    fun isPairExists_bruteForce_case1() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(), 0))
    }

    @Test
    fun isPairExists_bruteForce_case2() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(), 5))
    }

    @Test
    fun isPairExists_bruteForce_case3() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(4), 4))
    }

    @Test
    fun isPairExists_bruteForce_case4() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(4), 5))
    }

    @Test
    fun isPairExists_bruteForce_case5() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(4), 0))
    }

    @Test
    fun isPairExists_bruteForce_case6() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(6, 4), 6))
    }

    @Test
    fun isPairExists_bruteForce_case7() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(6, 4), 5))
    }

    @Test
    fun isPairExists_bruteForce_case8() {
        Assert.assertTrue(isPairExistsInUnsortedArray_bruteForce(intArrayOf(6, 0, 4), 6))
    }

    @Test
    fun isPairExists_bruteForce_case9() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(8, 1, 6, 20, -3), -6))
    }

    @Test
    fun isPairExists_bruteForce_case10() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(8, 1, 6, -6, -3), -6))
    }

    @Test
    fun isPairExists_bruteForce_case11() {
        Assert.assertTrue(isPairExistsInUnsortedArray_bruteForce(intArrayOf(8, 1, 6, 6, 4), 12))
    }

    @Test
    fun isPairExists_bruteForce_case12() {
        Assert.assertTrue(isPairExistsInUnsortedArray_bruteForce(intArrayOf(8, 1, 6, 6, 4), 12))
    }

    @Test
    fun isPairExists_bruteForce_case13() {
        Assert.assertTrue(isPairExistsInUnsortedArray_bruteForce(intArrayOf(3, 3, 3, 4, 2, 4, 2, 5, 1), 7))
    }

    @Test
    fun isPairExists_bruteForce_case14() {
        Assert.assertTrue(isPairExistsInUnsortedArray_bruteForce(intArrayOf(3, 1, 6, 4, 2, -1), 5))
    }

    @Test
    fun isPairExists_bruteForce_case15() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(3, 5, 20, 4, -3), 5))
    }

    @Test
    fun isPairExists_bruteForce_case16() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(8, 1, 6, 4, -3), -40))
    }

    @Test
    fun isPairExists_bruteForce_case17() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(8, 1, 6, 4, -3), 0))
    }

    @Test
    fun isPairExists_bruteForce_case18() {
        Assert.assertFalse(isPairExistsInUnsortedArray_bruteForce(intArrayOf(8, 1, 6, 4, -3), 0))
    }

    @Test
    fun isPairExists_bruteForce_case19() {
        Assert.assertTrue(isPairExistsInUnsortedArray_bruteForce(intArrayOf(8, 1, 6, 4, -3), 7))
    }

    @Test
    fun isPairExists_bruteForce_case20() {
        Assert.assertTrue(isPairExistsInUnsortedArray_bruteForce(intArrayOf(8, 1, 6, 4, -3), 1))
    }

    @Test
    fun isPairExists_bruteForce_case21() {
        Assert.assertFalse(
            isPairExistsInUnsortedArray_bruteForce(
                intArrayOf(8, 1, 6, 4, -3, 8, 1, 6, 4, 1, 6, 4, -3, 8, 1, 6, 4, -3),
                Math.pow(10.toDouble(), 5.toDouble()).toInt()
            )
        )
    }

    @Test
    fun isPairExists_bruteForce_case22() {
        Assert.assertTrue(
            isPairExistsInUnsortedArray_bruteForce(
                intArrayOf(8, 1, 6, 4, -3, 8, 1, 6, 4, 1, 6, 4, -3, 8, 1, 192, -80, -30),
                200
            )
        )
    }

    @Test
    fun isPairExists_bruteForce_case23() {
        Assert.assertTrue(
            isPairExistsInUnsortedArray_bruteForce(
                intArrayOf(8, 1, 6, 4, -3, 8, 1, 6, 4, 1, 6, 400, 600, 8, 1, 192, -80, -30),
                200
            )
        )
    }

    //    ===============================================================
    @Test
    fun isPairExists_optimized_case1() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(), 0))
    }

    @Test
    fun isPairExists_optimized_case2() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(), 5))
    }

    @Test
    fun isPairExists_optimized_case3() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(4), 4))
    }

    @Test
    fun isPairExists_optimized_case4() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(4), 5))
    }

    @Test
    fun isPairExists_optimized_case5() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(4), 0))
    }

    @Test
    fun isPairExists_optimized_case6() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(6, 4), 6))
    }

    @Test
    fun isPairExists_optimized_case7() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(6, 4), 5))
    }

    @Test
    fun isPairExists_optimized_case8() {
        Assert.assertTrue(isPairExistsInUnsortedArray_optimized(intArrayOf(6, 0, 4), 6))
    }

    @Test
    fun isPairExists_optimized_case9() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(8, 1, 6, 20, -3), -6))
    }

    @Test
    fun isPairExists_optimized_case10() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(8, 1, 6, -6, -3), -6))
    }

    @Test
    fun isPairExists_optimized_case11() {
        Assert.assertTrue(isPairExistsInUnsortedArray_optimized(intArrayOf(8, 1, 6, 6, 4), 12))
    }

    @Test
    fun isPairExists_optimized_case12() {
        Assert.assertTrue(isPairExistsInUnsortedArray_optimized(intArrayOf(8, 1, 6, 6, 4), 12))
    }

    @Test
    fun isPairExists_optimized_case13() {
        Assert.assertTrue(isPairExistsInUnsortedArray_optimized(intArrayOf(3, 3, 3, 4, 2, 4, 2, 5, 1), 7))
    }

    @Test
    fun isPairExists_optimized_case14() {
        Assert.assertTrue(isPairExistsInUnsortedArray_optimized(intArrayOf(3, 1, 6, 4, 2, -1), 5))
    }

    @Test
    fun isPairExists_optimized_case15() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(3, 5, 20, 4, -3), 5))
    }

    @Test
    fun isPairExists_optimized_case16() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(8, 1, 6, 4, -3), -40))
    }

    @Test
    fun isPairExists_optimized_case17() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(8, 1, 6, 4, -3), 0))
    }

    @Test
    fun isPairExists_optimized_case18() {
        Assert.assertFalse(isPairExistsInUnsortedArray_optimized(intArrayOf(8, 1, 6, 4, -3), 0))
    }

    @Test
    fun isPairExists_optimized_case19() {
        Assert.assertTrue(isPairExistsInUnsortedArray_optimized(intArrayOf(8, 1, 6, 4, -3), 7))
    }

    @Test
    fun isPairExists_optimized_case20() {
        Assert.assertTrue(isPairExistsInUnsortedArray_optimized(intArrayOf(8, 1, 6, 4, -3), 1))
    }

    @Test
    fun isPairExists_optimized_case21() {
        Assert.assertFalse(
            isPairExistsInUnsortedArray_optimized(
                intArrayOf(8, 1, 6, 4, -3, 8, 1, 6, 4, 1, 6, 4, -3, 8, 1, 6, 4, -3),
                Math.pow(10.toDouble(), 5.toDouble()).toInt()
            )
        )
    }

    @Test
    fun isPairExists_optimized_case22() {
        Assert.assertTrue(
            isPairExistsInUnsortedArray_optimized(
                intArrayOf(
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
                ), 200
            )
        )
    }

    @Test
    fun isPairExists_optimized_case23() {
        Assert.assertTrue(
            isPairExistsInUnsortedArray_optimized(
                intArrayOf(
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
                ), 200
            )
        )
    }

    //    ===============================================================
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
}