package com.noorifytech.algorithms.careem

import org.junit.Assert
import org.junit.Test

/**
 * Given an array of integers and target sum, find the subset of the given array that can make the target sum.
 * Example:
 * arr = [1, 2, 7, 5], targetSum = 8
 * Sub set = [1, 2, 5]
 */
class FindSubsetSum {

    private fun findSubsetSum(arr: IntArray, sum: Int): IntArray {
        val solutionVector = Array(arr.size) { false }
        val currentSum = 0
        val remainderSum = arr.sum()
        findSubSet(arr, sum, 0, currentSum, remainderSum, solutionVector)

        val result = findSolutionSubset(solutionVector, arr)

        return result.toIntArray()
    }

    private fun findSolutionSubset(solutionVector: Array<Boolean>, arr: IntArray): MutableList<Int> {
        val result = mutableListOf<Int>()

        (0 until solutionVector.size)
            .filter { solutionVector[it] }
            .mapTo(result) { arr[it] }

        return result
    }

    private fun findSubSet(arr: IntArray, targetSum: Int, i: Int, currentSum: Int, remainderSum: Int, solutionVector: Array<Boolean>): Array<Boolean> {
        solutionVector[i] = true

        // Base case
        if (currentSum + arr[i] == targetSum) {
            return solutionVector
        } else if (i+1 < arr.size && currentSum + arr[i] <= targetSum) {
            findSubSet(arr, targetSum, i + 1, currentSum + arr[i], remainderSum - arr[i], solutionVector)
        } // Check bounded function, (currentSum + remainderSum can make targetSum) AND (currentSum + nextElement can make targetSum)
        else if( i+1 < arr.size && currentSum + remainderSum >= targetSum && currentSum + arr[i+1] <= targetSum) {
            solutionVector[i] = false
            findSubSet(arr, targetSum, i + 1, currentSum, remainderSum - arr[i], solutionVector)
        }

        return solutionVector
    }

    @Test
    fun findSubsetSum_() {
        // Arrange
        val arr = intArrayOf(1, 2, 7, 5)

        // Act
        val result = findSubsetSum(arr, 8)
        println("result = ${result.toList()}")

        // Assert
        Assert.assertEquals(intArrayOf(1,2,5).toList(), result.toList())
    }

    @Test
    fun findSubsetSum_1() {
        // Arrange
        val arr = intArrayOf(2, 3, 7, 8, 10)

        // Act
        val result = findSubsetSum(arr, 11)
        println("result = ${result.toList()}")

        // Assert
        Assert.assertEquals(intArrayOf(3, 8).toList(), result.toList())
    }
}