package com.noorifytech.algorithms.namcc.recursion

import org.junit.Test

class NQueens {

    private fun placeNQueens(n: Int) {
        val board = init(n)
        solve(board, n = n, col = 0)
    }

    private fun solve(board: Array<Array<Int>>, n: Int, col: Int): Boolean {
        if (col == n) {
            printBoard(board)
            println()
            return false
        }

        for (i in 0 until n) {
            if (!isInTheLineOfAttack(board, i, col, n)) {
                board[i][col] = 1
                val canPlaceNextQueen = solve(board, n, col + 1)
                if (canPlaceNextQueen) {
                    return true
                } else {
                    board[i][col] = 0
                }
            }
        }

        return false
    }

    private fun isInTheLineOfAttack(board: Array<Array<Int>>, row: Int, col: Int, n: Int): Boolean {
        return isLeftAttacked(board, row, col) || isDiagonalAttacked(board, row, col, n)
    }

    private fun isLeftAttacked(board: Array<Array<Int>>, row: Int, col: Int): Boolean {
        for (i in col downTo 0) {
            if (board[row][i] == 1)
                return true
        }

        return false
    }

    private fun isDiagonalAttacked(board: Array<Array<Int>>, row: Int, col: Int, n: Int): Boolean {
        var i = row
        var j = col

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return true
            }
            i--
            j--
        }

        i = row
        j = col
        while (i < n && j >= 0) {
            if (board[i][j] == 1) {
                return true
            }
            i++
            j--
        }

        return false
    }

    @Test
    fun placeNQueens_case1() {
        placeNQueens(n = 4)
    }

    private fun printBoard(board: Array<Array<Int>>) {
        for (i in 0 until board.size) {
            for (j in 0 until board.size) {
                if (board[i][j] == 1) print("Q ") else print("_ ")
            }
            println()
        }
    }

    private fun init(n: Int): Array<Array<Int>> = Array(n) { Array(n) { 0 } }
}