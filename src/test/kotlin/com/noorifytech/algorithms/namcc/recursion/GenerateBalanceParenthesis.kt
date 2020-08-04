package com.noorifytech.algorithms.namcc.recursion

import org.junit.Test

class GenerateBalanceParenthesis {

    fun generateBalanceParenthesis(n: Int) {
        return solve(open = n, close = n, output = "")
    }

    private fun solve(open: Int, close: Int, output: String) {
        if (open == 0 && close == 0) {
            println(output)
            return
        }

        if (open > 0 && close > 0 && open < close) {
            solve(open - 1, close, "$output(")
            solve(open, close - 1, "$output)")
        } else if (open > 0) {
            solve(open - 1, close, "$output(")
        } else {
            solve(open, close - 1, "$output)")
        }
    }

    @Test
    fun case1() {
        generateBalanceParenthesis(3)
    }
}