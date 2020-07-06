package com.noorifytech.algorithms.careem

import org.junit.Assert
import org.junit.Test

/**
 * Given an array of integers and target sum, find whether the target sum exists using the subset of the given array.
 * Example:
 * arr = [1, 2, 7, 5], targetSum = 8
 * isSubsetSumExist = true
 */
class IsSubsetSumExist {

    private fun isSubsetSumExist(arr: IntArray, sum: Int): Boolean {
        val solution = Array(arr.size + 1) { BooleanArray(sum + 1) }

        // Memoization table's initial state
        for (i in 0..arr.size) solution[i][0] = true
        for (j in 1..sum) solution[0][j] = false

        for (i in 1..arr.size) {
            for (j in 1..sum) {
                val prevValue = solution[i - 1][j]
                if (j < arr[i-1]) solution[i][j] = prevValue
                else solution[i][j] = prevValue || solution[i - 1][j - arr[i]]
            }
        }

        printTable(solution)
        return solution[arr.size - 1][sum]
    }

    private fun printTable(solution: Array<BooleanArray>) {
        for (i in 0 until solution.size) {
            print("\n $i\t")
            for (j in 0 until solution[0].size) {
                print("${solution[i][j]} \t")
            }
        }

        println()
    }

    @Test
    fun isSubsetSumExist() {
        // Arrange
        val arr = intArrayOf(1, 2, 7, 5)

        // Act
        val result = isSubsetSumExist(arr, 8)

        // Assert
        Assert.assertTrue(result)
    }
}