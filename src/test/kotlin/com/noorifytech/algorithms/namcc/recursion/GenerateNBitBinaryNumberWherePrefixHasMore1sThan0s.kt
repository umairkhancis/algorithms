package com.noorifytech.algorithms.namcc.recursion

import org.junit.Test

class GenerateNBitBinaryNumberWherePrefixHasMore1sThan0s {
    private fun generateNBitBinaryNumberWherePrefixHasMore1sThan0s(n: Int) {
        return solve(n = n, ones = 0, zeros = 0, output = "")
    }

    private fun solve(n: Int, ones: Int, zeros: Int, output: String) {
        if (n == 0) {
            println(output)
            return
        }

        if (ones <= zeros) {
            solve(n - 1, ones + 1, zeros, output + "1")
        } else {
            solve(n - 1, ones + 1, zeros, output + "1")
            solve(n - 1, ones, zeros + 1, output + "0")
        }
    }

    @Test
    fun case1() {
        generateNBitBinaryNumberWherePrefixHasMore1sThan0s(3)
    }

    @Test
    fun case2() {
        generateNBitBinaryNumberWherePrefixHasMore1sThan0s(4)
    }
}