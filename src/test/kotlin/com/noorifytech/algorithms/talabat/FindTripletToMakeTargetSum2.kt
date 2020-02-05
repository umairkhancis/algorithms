package com.noorifytech.algorithms.talabat

import org.junit.Assert
import org.junit.Test

class FindTripletToMakeTargetSum2 {
    private fun findTripletToMakeTargetSum(arr: IntArray, targetSum: Int): IntArray {
        for (i in 0 until arr.size - 2) {
            val complement = targetSum - arr[i]

            val pair = findPairToMakeTheTargetSum(arr.sliceArray(i+1 until arr.size), complement)
            if(pair.isNotEmpty()) {
                return intArrayOf(arr[i], pair[0], pair[1])
            }
        }

        return intArrayOf()
    }

    private fun findPairToMakeTheTargetSum(arr: IntArray, targetSum: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for(i in 0 until arr.size) {
            val complement = targetSum - arr[i]
            if(map.containsKey(arr[i])) {
                return intArrayOf(arr[i], map[arr[i]]!!)
            }

            map[complement] = arr[i]
        }

        return intArrayOf()
    }

    @Test
    fun findTripletToMakeTargetSum_() {
        // Arrange
        val arr = intArrayOf(1, 3, 4, 12, 6, 9)

        // Act
        val result = findTripletToMakeTargetSum(arr, 24).toList()
        println("triplet = $result")

        // Assert
        Assert.assertEquals(intArrayOf(12, 3, 9).sorted(), result.sorted())
    }
}