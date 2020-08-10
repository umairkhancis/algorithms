package com.noorifytech.algorithms.namcc.recursion

import org.junit.Assert
import org.junit.Test

class JosephusProblem {

    private fun winningSeat(n: Int, k: Int): Int {
        val seats = Array(n) { 0 }
        for (i in 1..n) {
            seats[i - 1] = i
        }

        return solve(seats.toMutableList(), 0, k)
    }

    private fun solve(seats: MutableList<Int>, start: Int, k: Int): Int {
        if (seats.size == 1) {
            return seats[0]
        }

        val kill = (start + k) % seats.size
        seats.removeAt(kill)
        return solve(seats, kill, k)
    }

    @Test
    fun case1() {
        val map = mapOf(
            1 to 1,
            2 to 1,
            3 to 3,
            4 to 1,
            5 to 3,
            6 to 5,
            7 to 7,
            8 to 1,
            9 to 3,
            10 to 5,
            11 to 7,
            12 to 9
        )
        for (entry in map) {
            val winningSeat = winningSeat(entry.key, 1)
            println("For ${entry.key} seats; Winning seat is ${entry.value} ")
            Assert.assertEquals(winningSeat, entry.value)
        }
    }
}