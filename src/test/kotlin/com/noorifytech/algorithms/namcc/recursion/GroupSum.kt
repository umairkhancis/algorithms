package com.noorifytech.algorithms.namcc.recursion

import org.junit.Assert
import org.junit.Test

class GroupSum {
    private fun isGroupSumExists(arr: IntArray, target: Int): Boolean {
        return isGroupSumExists(arr, target, 0)
    }

    private fun isGroupSumExists(arr: IntArray, target: Int, index: Int): Boolean = when {
        index == arr.size && target == 0 -> true
        index == arr.size && target != 0 -> false
        else -> isGroupSumExists(arr, target, index + 1) || isGroupSumExists(arr, target - arr[index], index + 1)
    }

    private fun subSetSum(arr: IntArray, target: Int): List<Int> {
        val result = ArrayList<Int>()
        val finalResult = ArrayList<Int>()
        subSetSum(arr, target, 0, result, finalResult)
        return finalResult
    }

    private fun subSetSum(
        arr: IntArray,
        target: Int,
        index: Int,
        tempResult: ArrayList<Int>,
        finalResult: ArrayList<Int>
    ): ArrayList<Int> {
        if (target == 0 && index == arr.size) {
            finalResult.addAll(tempResult)
            return finalResult
        } else if (index == arr.size) {
            return finalResult
        }

        subSetSum(arr, target, index + 1, tempResult, finalResult)
        tempResult.add(arr[index])
        subSetSum(arr, target - arr[index], index + 1, tempResult, finalResult)
        tempResult.remove(arr[index]) // backtracking

        return finalResult
    }

    @Test
    fun subSetSum_case1() = Assert.assertEquals(listOf(6, 3), subSetSum(intArrayOf(5, 6, 3, 4, 7), 9))

    @Test
    fun subSetSum_case2() = Assert.assertEquals(listOf(11, 5), subSetSum(intArrayOf(5, 6, 3, 4, 11), 15))

    @Test
    fun subSetSum_case3() = Assert.assertEquals(emptyList<Int>(), subSetSum(intArrayOf(5, 6, 3, 4, 11), 45))

    @Test
    fun subSetSum_case4() = Assert.assertEquals(listOf(5, 6, 3, 4, 11), subSetSum(intArrayOf(5, 6, 3, 4, 11), 29))

    @Test
    fun subSetSum_case5() = Assert.assertEquals(listOf(5), subSetSum(intArrayOf(5, 6, 3, 4, 11), 5))

    @Test
    fun subSetSum_case6() = Assert.assertEquals(listOf(6), subSetSum(intArrayOf(5, 6, 3, 4, 11), 6))

    @Test
    fun subSetSum_case7() = Assert.assertEquals(listOf(3), subSetSum(intArrayOf(5, 6, 3, 4, 11), 3))

    @Test
    fun subSetSum_case8() = Assert.assertEquals(listOf(4), subSetSum(intArrayOf(5, 6, 3, 4, 11), 4))

    @Test
    fun subSetSum_case9() = Assert.assertEquals(listOf(11), subSetSum(intArrayOf(5, 6, 3, 4, 11), 11))

    @Test
    fun isGroupSumExists_case1() = Assert.assertTrue(isGroupSumExists(intArrayOf(5, 6, 3, 4, 7), 9))

    @Test
    fun isGroupSumExists_case2() = Assert.assertTrue(isGroupSumExists(intArrayOf(5, 6, 3, 4, 11), 15))

    @Test
    fun isGroupSumExists_case3() = Assert.assertFalse(isGroupSumExists(intArrayOf(5, 6, 3, 4, 11), 45))

    @Test
    fun isGroupSumExists_case4() = Assert.assertTrue(isGroupSumExists(intArrayOf(5, 6, 3, 4, 11), 29))

    @Test
    fun isGroupSumExists_case5() = Assert.assertTrue(isGroupSumExists(intArrayOf(5, 6, 3, 4, 11), 5))

    @Test
    fun isGroupSumExists_case6() = Assert.assertTrue(isGroupSumExists(intArrayOf(5, 6, 3, 4, 11), 6))

    @Test
    fun isGroupSumExists_case7() = Assert.assertTrue(isGroupSumExists(intArrayOf(5, 6, 3, 4, 11), 3))

    @Test
    fun isGroupSumExists_case8() = Assert.assertTrue(isGroupSumExists(intArrayOf(5, 6, 3, 4, 11), 4))

    @Test
    fun isGroupSumExists_case9() = Assert.assertTrue(isGroupSumExists(intArrayOf(5, 6, 3, 4, 11), 11))
}