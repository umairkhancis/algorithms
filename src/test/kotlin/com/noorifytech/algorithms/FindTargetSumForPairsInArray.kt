package com.noorifytech.kotlinplayground

import org.junit.Assert
import org.junit.Test

class FindTargetSumForPairsInArray {

    private fun isSumExistsInPair(arr: Array<Int>, sum: Int): Boolean {
        val map = hashMapOf<Int, Int>()
        for (element in arr) {
            if (element in map) {
                val diff = map[element]
                if(diff?.plus(element) == sum) {
                    return true
                }
            } else {
                map[sum - element] = element
            }
        }

        return false
    }

    @Test
    fun test_isSumExistsInPair_1() {
        Assert.assertTrue(isSumExistsInPair(arrayOf(1, 2, 4, 4), 8))
    }

    @Test
    fun test_isSumExistsInPair_2() {
        Assert.assertTrue(isSumExistsInPair(arrayOf(1, 2, 3, 9), 12))
    }

    @Test
    fun test_isSumExistsInPair_3() {
        Assert.assertFalse(isSumExistsInPair(arrayOf(1, 1, 4, 9), 8))
    }

    @Test
    fun test_isSumExistsInPair_4() {
        Assert.assertFalse(isSumExistsInPair(arrayOf(), 0))
    }

    @Test
    fun test_isSumExistsInPair_5() {
        Assert.assertFalse(isSumExistsInPair(arrayOf(1), 1))
    }

    @Test
    fun test_isSumExistsInPair_6() {
        Assert.assertTrue(isSumExistsInPair(arrayOf(-1, -2, 4, 6, -5), -1))
    }
}
