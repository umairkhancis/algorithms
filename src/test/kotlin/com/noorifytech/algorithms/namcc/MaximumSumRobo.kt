package com.noorifytech.algorithms.namcc

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

class MaximumSumRobo {
    fun getMaxSumRobo(matrix: List<List<Int>>, row: Int, col: Int): Int {
        return getMaxSumRobo(matrix, row, col, 0)
    }

    private fun getMaxSumRobo(matrix: List<List<Int>>, row: Int, col: Int, sum: Int): Int {
        if (row == matrix.size - 1 && matrix.isNotEmpty() && col == matrix[0].size - 1) return sum + matrix[row][col]
        if (row >= matrix.size || (matrix.isNotEmpty() && col >= matrix[0].size)) return 0

        val tempSum = sum + matrix[row][col]
        val right = getMaxSumRobo(matrix, row, col + 1, tempSum)
        val down = getMaxSumRobo(matrix, row + 1, col, tempSum)

        return max(right, down)
    }

    @Test
    fun getMaxSumRobo_case0() {
        // Arrange
        val matrix: List<List<Int>> = listOf()

        // Act
        val result = getMaxSumRobo(matrix, 0, 0)

        // Assert
        Assert.assertEquals(0, result)
    }

    @Test
    fun getMaxSumRobo_case1() {
        // Arrange
        val matrix: List<List<Int>> = listOf(
            listOf(1, 2, 1),
            listOf(2, 3, 2),
            listOf(1, 4, 1)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0)

        // Assert
        Assert.assertEquals(11, result)
    }

    @Test
    fun getMaxSumRobo_case2() {
        val matrix = listOf(
            listOf(7, 3, 0, 5, 2),
            listOf(4, 3, 8, 6, 9),
            listOf(0, 9, 5, 7, 8),
            listOf(3, 8, 4, 0, 6),
            listOf(6, 2, 5, 7, 0)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(51, result)
    }

    @Test
    fun getMaxSumRobo_case3() {

        val matrix = listOf(
            listOf(1, 7, 6, 4, 3),
            listOf(3, 5, 8, 0, 2),
            listOf(5, 2, 6, 1, 0),
            listOf(7, 8, 4, 9, 1),
            listOf(6, 3, 5, 7, 4)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(52, result)
    }

    @Test
    fun getMaxSumRobo_case4() {

        val matrix = listOf(
            listOf(6, 1, 4, 3, 8),
            listOf(5, 3, 1, 7, 9),
            listOf(3, 8, 0, 2, 6),
            listOf(7, 5, 2, 0, 6),
            listOf(6, 9, 7, 4, 3)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(50, result)
    }

    @Test
    fun getMaxSumRobo_case5() {

        val matrix = listOf(
            listOf(0, 7, 8, 4, 2),
            listOf(6, 1, 2, 4, 5),
            listOf(8, 2, 7, 9, 0),
            listOf(0, 3, 6, 9, 8),
            listOf(1, 6, 5, 3, 0)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(50, result)
    }

    @Test
    fun getMaxSumRobo_case6() {

        val matrix = listOf(
            listOf(8, 5, 0, 3, 1),
            listOf(9, 0, 5, 3, 7),
            listOf(4, 8, 9, 0, 2),
            listOf(5, 4, 1, 2, 9),
            listOf(7, 9, 0, 1, 2)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(52, result)
    }

    @Test
    fun getMaxSumRobo_case7() {

        val matrix = listOf(
            listOf(9, 1, 0, 5, 8),
            listOf(0, 7, 9, 6, 4),
            listOf(8, 0, 5, 3, 1),
            listOf(3, 0, 1, 6, 9),
            listOf(2, 6, 8, 0, 3)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(53, result)
    }

    @Test
    fun getMaxSumRobo_case8() {

        val matrix = listOf(
            listOf(0, 4, 2, 7, 6),
            listOf(1, 2, 6, 7, 8),
            listOf(7, 1, 4, 0, 3),
            listOf(7, 4, 1, 5, 6),
            listOf(7, 1, 5, 9, 6)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(43, result)
    }

    @Test
    fun getMaxSumRobo_case9() {

        val matrix = listOf(
            listOf(1, 6, 8, 4, 2),
            listOf(2, 7, 1, 4, 0),
            listOf(1, 4, 2, 9, 3),
            listOf(1, 6, 9, 4, 7),
            listOf(2, 3, 8, 4, 6)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(51, result)
    }

    @Test
    fun getMaxSumRobo_case10() {

        val matrix = listOf(
            listOf(2, 0, 3, 7, 4),
            listOf(1, 6, 4, 0, 9),
            listOf(6, 3, 5, 0, 9),
            listOf(6, 0, 2, 3, 5),
            listOf(2, 4, 8, 1, 9)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(48, result)
    }

    @Test
    fun getMaxSumRobo_case11() {

        val matrix = listOf(
            listOf(1, 2, 6, 4, 9),
            listOf(1, 9, 2, 6, 7),
            listOf(5, 8, 1, 2, 3),
            listOf(8, 9, 6, 1, 2),
            listOf(4, 7, 2, 8, 5)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(51, result)
    }

    @Test
    fun getMaxSumRobo_case12() {

        val matrix = listOf(
            listOf(3, 1, 6, 4, 8),
            listOf(2, 9, 6, 1, 8),
            listOf(5, 2, 4, 3, 8),
            listOf(9, 7, 3, 8, 6),
            listOf(8, 7, 0, 9, 3)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(49, result)
    }

    @Test
    fun getMaxSumRobo_case13() {

        val matrix = listOf(
            listOf(6, 3, 4, 2, 1),
            listOf(0, 3, 4, 2, 7),
            listOf(6, 4, 8, 7, 5),
            listOf(1, 7, 2, 6, 9),
            listOf(9, 1, 2, 0, 8)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(55, result)
    }

    @Test
    fun getMaxSumRobo_case14() {

        val matrix = listOf(
            listOf(3, 6, 0, 8, 4),
            listOf(1, 9, 5, 2, 4),
            listOf(6, 4, 9, 7, 8),
            listOf(9, 4, 8, 0, 2),
            listOf(4, 6, 3, 7, 0)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(50, result)
    }

    @Test
    fun getMaxSumRobo_case15() {

        val matrix = listOf(
            listOf(7, 8, 6, 3, 0),
            listOf(0, 9, 2, 8, 4),
            listOf(7, 2, 8, 1, 9),
            listOf(2, 4, 1, 3, 9),
            listOf(0, 4, 7, 3, 9)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(65, result)
    }

    @Test
    fun getMaxSumRobo_case16() {

        val matrix = listOf(
            listOf(4, 9, 5, 3, 7),
            listOf(6, 7, 8, 0, 3),
            listOf(5, 9, 0, 3, 4),
            listOf(4, 9, 5, 6, 3),
            listOf(0, 4, 2, 8, 5)
        )

        // Act
        val result = getMaxSumRobo(matrix, 0, 0, 0)

        // Assert
        Assert.assertEquals(62, result)
    }
}