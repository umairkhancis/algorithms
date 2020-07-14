package com.noorifytech.algorithms.namcc.recursion

import com.noorifytech.algorithms.util.runAllTests
import org.junit.Test
import kotlin.math.max


class MaximumSumRobo {
    private fun getMaxSumRobo(matrix: List<List<Double>>): Double {
        return getMaxSumRobo(matrix, 0, 0, 0.0)
    }

    private fun getMaxSumRobo(matrix: List<List<Double>>, row: Int, col: Int, sum: Double): Double {
        if (row == matrix.size - 1 && matrix.isNotEmpty() && col == matrix[0].size - 1) return sum + matrix[row][col]
        if (row >= matrix.size || (matrix.isNotEmpty() && col >= matrix[0].size)) return 0.0

        val tempSum = sum + matrix[row][col]
        val right = getMaxSumRobo(matrix, row, col + 1, tempSum)
        val down = getMaxSumRobo(matrix, row + 1, col, tempSum)

        return max(right, down)
    }

    @Test
    fun getMaxSumRobo_caseAll() {
        runAllTests<List<List<Double>>, Double>("src/test/resources/max-robo-matrix-sum-tests.json") {
            getMaxSumRobo(it)
        }
    }
}