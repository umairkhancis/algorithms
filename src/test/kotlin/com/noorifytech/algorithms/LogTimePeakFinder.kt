package com.noorifytech.kotlinplayground

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LogTimePeakFinder {

    private fun findPeakInLogTime(arr: Array<Int>): Int {
        val n = arr.size

        return when {
            arr[(n / 2 + 1) % n] > arr[n / 2] -> findPeakInLogTime(arr.sliceArray(n / 2 until n))
            arr[(n / 2 - 1) % n] > arr[n / 2] -> findPeakInLogTime(arr.sliceArray(0 until n / 2))
            else -> arr[n / 2]
        }
    }

    /**
     * Ten input size
     */
    @Test
    fun test_findPeak_1() {
        Assert.assertEquals(9, findPeakInLogTime(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
    }

    /**
     * Thousand input size
     */
    @Test
    fun test_findPeak_2() {
        val startTime = System.currentTimeMillis()

        val arr = IntArray(1000) { it * 1 }
        Assert.assertEquals(1000 - 1, findPeakInLogTime(arr.toTypedArray()))

        val endTime = System.currentTimeMillis()
        println("findPeakInLogTime took ${(endTime - startTime)} ms for the input size ${arr.size}")
    }

    /**
     * A Million input size
     */
    @Test
    fun test_findPeak_3() {
        val startTime = System.currentTimeMillis()

        val arr = IntArray(1000000) { it * 1 }
        Assert.assertEquals(1000000 - 1, findPeakInLogTime(arr.toTypedArray()))

        val endTime = System.currentTimeMillis()
        println("findPeakInLogTime took ${(endTime - startTime)} ms for the input size ${arr.size}")
    }

    /**
     * Ten Million input size
     */
    @Test
    fun test_findPeak_4() {
        val startTime = System.currentTimeMillis()

        val arr = IntArray(10000000) { it * 1 }
        Assert.assertEquals(10000000 - 1, findPeakInLogTime(arr.toTypedArray()))

        val endTime = System.currentTimeMillis()
        println("findPeakInLogTime took ${(endTime - startTime)} ms for the input size ${arr.size}")
    }

    /**
     * Hundred Million input size
     */
    @Test
    fun test_findPeak_5() {
        val startTime = System.currentTimeMillis()

        val arr = IntArray(100000000) { it * 1 }
        Assert.assertEquals(100000000 - 1, findPeakInLogTime(arr.toTypedArray()))

        val endTime = System.currentTimeMillis()
        println("findPeakInLogTime took ${(endTime - startTime)} ms for the input size ${arr.size}")
    }
}
