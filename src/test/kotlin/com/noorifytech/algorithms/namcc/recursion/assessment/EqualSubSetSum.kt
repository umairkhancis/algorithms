package com.noorifytech.algorithms.namcc.recursion.assessment

import org.junit.Assert
import org.junit.Test

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].


Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 */
class EqualSubSetSum {

    private fun equalSubSetSum(arr: IntArray): Boolean {
        return equalSubSetSum(arr, 0, 0, 0)
    }

    private fun equalSubSetSum(arr: IntArray, start: Int, group1: Int, group2: Int): Boolean {
        if (start == arr.size) {
            return group1 == group2
        }

        return equalSubSetSum(arr, start + 1, group1 + arr[start], group2)
                || equalSubSetSum(arr, start + 1, group1, group2 + arr[start])
    }

    @Test
    fun case1() {
        Assert.assertTrue(equalSubSetSum(intArrayOf(1, 5, 11, 5)))
    }

    @Test
    fun case2() {
        Assert.assertFalse(equalSubSetSum(intArrayOf(1, 2, 3, 5)))
    }
}