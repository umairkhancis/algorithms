package com.noorifytech.algorithms.talabat

import org.junit.Assert
import org.junit.Test

class AddLargeNumbers {
    private fun addLargeNumbers(numbers: List<String>): String {
        var result = ""

        if (numbers.isEmpty()) {
            return result
        } else if (numbers.size < 2) {
            return numbers[0]
        }

        for (i in 1 until numbers.size) {
            val current = numbers[i]
            var prev = ""
            if(result.isEmpty()) {
                prev = numbers[i - 1]
            } else {
                prev = result
            }

            result = addTwoLargeNumbers(prev, current)
        }

        return result
    }

    private fun addTwoLargeNumbers(prev: String, current: String): String {
        var result = ""
        var biggerNum = ""
        var smallerNum = ""
        if (prev.length > current.length) {
            biggerNum = prev
            smallerNum = current
        } else {
            biggerNum = current
            smallerNum = prev
        }

        val preceedingZeros = biggerNum.length - smallerNum.length
        for (i in 0 until preceedingZeros) {
            smallerNum = "0$smallerNum"
        }

        var carry = 0
        for (k in biggerNum.length - 1 downTo 0) {
            val currentDigitSum = (Integer.parseInt(biggerNum[k].toString()) + Integer.parseInt(smallerNum[k].toString()) + carry)
            if (currentDigitSum >= 10) {
                val unit = currentDigitSum % 10
                result = unit.toString() + result
                carry = 1
            } else {
                result = currentDigitSum.toString() + result
                carry = 0
            }
        }

        if(carry == 1) {
            result = carry.toString() + result
        }

        return result
    }

    @Test
    fun addLargeNumbers_whenEmptyArray() {
        // Arrange
        val numbers = emptyList<String>()

        // Act
        val result = addLargeNumbers(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("", result)
    }

    @Test
    fun addLargeNumbers_whenSingleItemArray() {
        // Arrange
        val numbers = listOf("1111")

        // Act
        val result = addLargeNumbers(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("1111", result)
    }

    @Test
    fun addLargeNumbers_whenOnlyTwoItemsArray() {
        // Arrange
        val numbers = listOf("1111", "3333")

        // Act
        val result = addLargeNumbers(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("4444", result)
    }

    @Test
    fun addLargeNumbers_whenMoreThanTwoItemsArray() {
        // Arrange
        val numbers = listOf("1111", "3333", "1111")

        // Act
        val result = addLargeNumbers(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("5555", result)
    }

    @Test
    fun addLargeNumbers_whenTwoItemsArrayOneNumberIsLargerThanOther() {
        // Arrange
        val numbers = listOf("1111", "333333")

        // Act
        val result = addLargeNumbers(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("334444", result)
    }

    @Test
    fun addLargeNumbers_whenTwoItemsArrayWithCarry() {
        // Arrange
        val numbers = listOf("1111", "9999")

        // Act
        val result = addLargeNumbers(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("11110", result)
    }

    @Test
    fun addLargeNumbers_whenMoreThanTwoItemsArrayWithVariableLengthItems() {
        // Arrange
        val numbers = listOf("1111", "9999", "44", "5555", "33", "1")

        // Act
        val result = addLargeNumbers(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("16743", result)
    }
}