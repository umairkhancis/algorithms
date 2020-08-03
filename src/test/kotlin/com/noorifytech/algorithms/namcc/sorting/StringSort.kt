package com.noorifytech.algorithms.namcc.sorting

import org.junit.Assert
import org.junit.Test

class StringSort {
    private fun stringSort(str: String): String {
        val freqMap = IntArray(256) { 0 }
        for (i in str) {
            freqMap[i.toInt()]++
        }

        var res = ""
        for (i in 0 until 256) {
            if (freqMap[i] > 0) {
                for (j in 0 until freqMap[i]) {
                    res += i.toChar()
                }
            }
        }

        return res
    }

    @Test
    fun stringSort_case1() {
        Assert.assertEquals("aaaddszzzz", stringSort("zzzzaaasdd"))
    }

    @Test
    fun stringSort_case2() {
        Assert.assertEquals("aaaabnnn", stringSort("anananab"))
    }
}