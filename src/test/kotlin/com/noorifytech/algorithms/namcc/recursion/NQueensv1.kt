package com.noorifytech.algorithms.namcc.recursion

import org.junit.Test
import java.util.ArrayList

class NQueensv1 {

    private fun placeNQueens(n: Int) {
        val board = init(n)
        solve(board, n, 0, 0)
    }

    private fun solve(board: List<List<Int>>, n: Int, row: Int, col: Int) {
        if (n == 0) return
        if ((row < 0 || row > board.size - 1) || (col < 0 || col > board.size - 1)) return

        if (!isInTheLineOfAttack(board, row, col)) {
            board[row][col].plus(1)
            solve(board, n - 1, row, col)
        } else {
            solve(board, n, row + 1, col)
            solve(board, n, row - 1, col)
            solve(board, n, row, col + 1)
            solve(board, n, row, col - 1)
        }
    }

    private fun isInTheLineOfAttack(board: List<List<Int>>, row: Int, col: Int): Boolean {
        if ((row < 0 || row > board.size - 1) || (col < 0 || col > board.size - 1)) return false
        if (board[row][col] == 1) return true

        val left = isInTheLineOfAttack(board, row, col - 1)
        val right = isInTheLineOfAttack(board, row, col + 1)
        val up = isInTheLineOfAttack(board, row - 1, col)
        val down = isInTheLineOfAttack(board, row + 1, col)
        val diagonal1 = isInTheLineOfAttack(board, row - 1, col + 1)
        val diagonal2 = isInTheLineOfAttack(board, row + 1, col + 1)
        val diagonal3 = isInTheLineOfAttack(board, row - 1, col - 1)
        val diagonal4 = isInTheLineOfAttack(board, row + 1, col - 1)

        return left && right && up && down && diagonal1 && diagonal2 && diagonal3 && diagonal4
    }

    @Test
    fun placeNQueens_case1() {
        placeNQueens(n = 2)
    }

    private fun init(n: Int): List<List<Int>> {
        val board: MutableList<List<Int>> = ArrayList(n)
        for (i in 0 until n) {
            val row = mutableListOf<Int>()
            for (j in 0 until n) {
                row.add(0)
            }
            board.add(row)
        }

        return board
    }
}