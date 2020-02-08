package com.noorifytech.algorithms.Talabat

import org.junit.Assert
import org.junit.Test


/**
 * Given an int array, returns the sum of all elements in the array.
 * Example:
 * Input: arr = [1, 10, 100, 1000, 10000, 100000]
 * Output: 111111
 */
class FinArraySum {
    private fun findArraySum(numbers: Array<Int>): String {
        var result = ""

        if (numbers.isEmpty()) {
            return result
        } else if (numbers.size < 2) {
            return numbers[0].toString()
        }

        for (i in 1 until numbers.size) {
            val current = numbers[i].toString()
            val prev: String = if(result.isEmpty()) {
                numbers[i - 1].toString()
            } else {
                result
            }

            result = sumTwoIntAsString(prev, current)
        }

        return result
    }

    private fun sumTwoIntAsString(num1: String, num2: String): String {
        var result = ""
        var biggerNum = ""
        var smallerNum = ""
        if (num1.length > num2.length) {
            biggerNum = num1
            smallerNum = num2
        } else {
            biggerNum = num2
            smallerNum = num1
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
    fun findArraySum_whenEmptyArray() {
        // Arrange
        val numbers = arrayOf<Int>()

        // Act
        val result = findArraySum(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("", result)
    }

    @Test
    fun findArraySum_whenSingleItemArray() {
        // Arrange
        val numbers = arrayOf(1111)

        // Act
        val result = findArraySum(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("1111", result)
    }

    @Test
    fun findArraySum_whenOnlyTwoItemsArray() {
        // Arrange
        val numbers = arrayOf(1111, 3333)

        // Act
        val result = findArraySum(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("4444", result)
    }

    @Test
    fun findArraySum_whenMoreThanTwoItemsArray() {
        // Arrange
        val numbers = arrayOf(1111, 3333, 1111)

        // Act
        val result = findArraySum(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("5555", result)
    }

    @Test
    fun findArraySum_whenTwoItemsArrayOneNumberIsLargerThanOther() {
        // Arrange
        val numbers = arrayOf(1111, 333333)

        // Act
        val result = findArraySum(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("334444", result)
    }

    @Test
    fun findArraySum_whenTwoItemsArrayWithCarry() {
        // Arrange
        val numbers = arrayOf(1111, 9999)

        // Act
        val result = findArraySum(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("11110", result)
    }

    @Test
    fun findArraySum_whenMoreThanTwoItemsArrayWithVariableLengthItems() {
        // Arrange
        val numbers = arrayOf(1111, 9999, 44, 5555, 33, 1)

        // Act
        val result = findArraySum(numbers)
        println("result = $result")

        // Assert
        Assert.assertEquals("16743", result)
    }
}