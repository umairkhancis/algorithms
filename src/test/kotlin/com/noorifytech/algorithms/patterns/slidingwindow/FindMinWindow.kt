package com.noorifytech.algorithms.patterns.slidingwindow

import org.junit.Assert
import org.junit.Test
import java.lang.Math.min

class FindMinWindow {

    private fun findMinWindow(s: String, t: String): String {
        var start = 0
        var end = 0
        var result = ""

        // validation
        if (end >= s.length) {
            throw IllegalArgumentException("Input array is not of appropriate size.")
        }

        var currentMin = Int.MAX_VALUE
        val frequencyTable = frequencyTable(t)
        var counter = frequencyTable.values.sum()
        val arr = s.toCharArray()
        while (end < arr.size) {
            if (arr[start] in t) {

                if (arr[end] in t) {
                    counter--
                } else {
                    end++
                }

                if(counter <= 0) {
                    val windowSize = end-start+1
                    currentMin = min(windowSize, currentMin)
                    result = s.substring(start, end)
                }
            } else {
                start++
            }
        }

        return result
    }

    private fun frequencyTable(t: String): Map<Char, Int> {
        val freqTable = mutableMapOf<Char, Int>()
        t.map { freqTable[it] = 0 }
        t.map { freqTable[it]?.plus(1) }

        return freqTable
    }

    @Test
    fun test_1() {
        // Arrange
        val expectedResult = "BANC"
        val s = "ADOBECODEBANC"
        val t = "ABC"

        // Act
        val actualResult = findMinWindow(s, t)

        // Assert
        Assert.assertEquals(expectedResult, actualResult)
    }
}