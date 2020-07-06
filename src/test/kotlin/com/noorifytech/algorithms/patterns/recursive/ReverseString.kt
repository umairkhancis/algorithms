package com.noorifytech.algorithms.patterns.recursive

import org.junit.Assert
import org.junit.Test

class ReverseString {
    private fun reverse(str: String): String {
        if(str.isEmpty()) {
            return ""
        }

        return reverse(str.slice(1 until str.lastIndex)) + str[0]
    }

    @Test
    fun reverse_() {
        // Arrange
        val str = "car"

        // Act
        val result = reverse(str)
        println("reversed = $result")

        // Assert
        Assert.assertEquals("riamu", result)
    }
}