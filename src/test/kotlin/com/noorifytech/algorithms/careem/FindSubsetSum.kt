package com.noorifytech.algorithms.careem

import org.junit.Assert
import org.junit.Test

class FindSubsetSum {

    private fun findSubsetSum(arr: IntArray, sum: Int): Array<Boolean> {
        val solutionVector = Array(arr.size) { false }
        val currentSum = 0
        val remainderSum = arr.sum()
        findSubSet(arr, sum, 0, currentSum, remainderSum, solutionVector)
        return solutionVector
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
        Assert.assertEquals(booleanArrayOf(true, true, false, true).toList(), result.toList())
    }

    @Test
    fun findSubsetSum_1() {
        // Arrange
        val arr = intArrayOf(2, 3, 7, 8, 10)

        // Act
        val result = findSubsetSum(arr, 11)
        println("result = ${result.toList()}")

        // Assert
        Assert.assertEquals(booleanArrayOf(false, true, false, true, false).toList(), result.toList())
    }
}