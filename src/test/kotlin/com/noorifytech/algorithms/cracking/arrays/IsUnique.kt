package com.noorifytech.algorithms.cracking.arrays

import org.junit.Assert
import org.junit.Test

/**
 * Find out whether the given string has unique characters or not?
 * Returns true/false
 *
 * Approaches:
 * 1- Brute Force O(N^2)
 * 2- Bit Vector O(N)
 * 3- HashTable/Set O(N) and O(c)
 * 4- Sort the string arr and then find out uniqueness O(NLogN)
 */
class IsUnique {
    private fun isUnique2(str: String): Boolean {
        if(str.isEmpty() || str.length > 128)
            return false

        val bitVector = BooleanArray(128)
        for(c in str) {
            val ascii = c.toInt()

            if(bitVector[ascii]) {
                return false
            } else {
                bitVector[ascii] = true
            }
        }

        return true
    }

    private fun isUnique(str: String): Boolean {
        if(str.isEmpty()) return false

        val charArr = str.toCharArray().sortedArray()

        for(i in 0..charArr.size-2) {
            val current = charArr[i]
            val next = charArr[i+1]

            if(current == next) {
                return false
            }
        }

        return true
    }

    @Test
    fun isUnique_whenUniqueCharString_returnsTrue() {
        // Arrange
        val str = "UMAIR"

        // Act
        val result  = isUnique(str)

        // Assert
        Assert.assertTrue(result)
    }

    @Test
    fun isUnique_whenNonUniqueCharString_returnsFalse() {
        // Arrange
        val str = "AMAR"

        // Act
        val result  = isUnique(str)

        // Assert
        Assert.assertFalse(result)
    }

    @Test
    fun isUnique_whenEmptyCharString_returnsFalse() {
        // Arrange
        val str = ""

        // Act
        val result  = isUnique(str)

        // Assert
        Assert.assertFalse(result)
    }
}