package com.noorifytech.algorithms.talabat

import org.junit.Assert
import org.junit.Test

class ReverseStringPreservingHyphenPositions {
    private fun reverseStringPreservingHyphenPositions(str: String): String {
        val arr = str.toCharArray()
        var i = 0
        var j = arr.size - 1

        while (i < j) {
            if (arr[i] == '-') {
                i++
                continue
            }

            if (arr[j] == '-') {
                j--
                continue
            }

            // Swap
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp

            // progress after successful swaps
            i++
            j--
        }

        return String(arr)
    }

    @Test
    fun reverse_() {
        // Arrange
        val str = "umair"

        // Act
        val result = reverseStringPreservingHyphenPositions(str)
        println("reversed = $result")

        // Assert
        Assert.assertEquals("riamu", result)
    }

    @Test
    fun reverseStringPreservingHyphenPositions_1() {
        // Arrange
        val str = "nahkriamu-imur"

        // Act
        val result = reverseStringPreservingHyphenPositions(str)
        println("reversed = $result")

        // Assert
        Assert.assertEquals("rumiumair-khan", result)
    }

    @Test
    fun reverseStringPreservingHyphenPositions_2() {
        // Arrange
        val str = "nahk-riamu-imur"

        // Act
        val result = reverseStringPreservingHyphenPositions(str)
        println("reversed = $result")

        // Assert
        Assert.assertEquals("rumi-umair-khan", result)
    }

    @Test
    fun reverseStringPreservingHyphenPositions_3() {
        // Arrange
        val str = "nahkriamuimur-.ris"

        // Act
        val result = reverseStringPreservingHyphenPositions(str)
        println("reversed = $result")

        // Assert
        Assert.assertEquals("sir.rumiumair-khan", result)
    }
}