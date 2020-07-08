package com.noorifytech.algorithms.mit

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LinearTimePeakFinder {

    private fun findPeakInLinearTime(arr: Array<Int>): Int {
        var peak = -1
        for (i in 1 until arr.size) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[(i + 1) % arr.size]) {
                peak = arr[i]
                break
            }
        }

        return peak
    }

    /**
     * Ten input size
     */
    @Test
    fun test_findPeak_1() {
        Assert.assertEquals(9, findPeakInLinearTime(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
    }

    /**
     * Thousand input size
     */
    @Test
    fun test_findPeak_2() {
        val startTime = System.currentTimeMillis()

        val arr = IntArray(1000) { it * 1 }
        Assert.assertEquals(1000 - 1, findPeakInLinearTime(arr.toTypedArray()))

        val endTime = System.currentTimeMillis()
        println("findPeakInLinearTime took ${(endTime - startTime)} ms for the input size ${arr.size}")
    }

    /**
     * A Million input size
     */
    @Test
    fun test_findPeak_3() {
        val startTime = System.currentTimeMillis()

        val arr = IntArray(1000000) { it * 1 }
        Assert.assertEquals(1000000 - 1, findPeakInLinearTime(arr.toTypedArray()))

        val endTime = System.currentTimeMillis()
        println("findPeakInLinearTime took ${(endTime - startTime)} ms for the input size ${arr.size}")
    }

    /**
     * Ten Million input size
     */
    @Test
    fun test_findPeak_4() {
        val startTime = System.currentTimeMillis()

        val arr = IntArray(10000000) { it * 1 }
        Assert.assertEquals(10000000 - 1, findPeakInLinearTime(arr.toTypedArray()))

        val endTime = System.currentTimeMillis()
        println("findPeakInLinearTime took ${(endTime - startTime)} ms for the input size ${arr.size}")
    }
}
