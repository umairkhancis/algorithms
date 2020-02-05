package com.noorifytech.algorithms.talabat

import org.junit.Assert
import org.junit.Test

class FindTripletToMakeTargetSum {
    private fun findTripletToMakeTargetSum(arr: IntArray, sum: Int): IntArray {
        var triplet = intArrayOf()

        for (i in 0 until arr.size - 2) {
            val tempSum = sum - arr[i]

            val map = mutableMapOf<Int, Int>()
            for(j in i+1 until arr.size) {
                val complement = tempSum - arr[j]
                if(map.containsKey(complement)) {
                    triplet = intArrayOf(arr[i], complement, map[complement]!!)
                    return triplet
                }

                map[arr[j]] = complement
            }
        }

        return triplet
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