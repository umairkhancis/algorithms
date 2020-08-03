package com.noorifytech.algorithms.namcc.recursion

import org.junit.Test

class AllSubstring {
    private fun printAllSubStrings(str: String) {
        for (i in 0 until str.length) {
            solve(str, 0, i)
        }
    }

    private fun solve(str: String, start: Int, length: Int) {
        if (start == str.length) return
        val sub = str.substring(start, start + length - 1)
        println("$sub, ${str.substring(1)}")
        solve(str, start + 1, length)
    }

    @Test
    fun printAllSubStrings_case1() {
        printAllSubStrings("ALi")
    }

    @Test
    fun printAllSubStrings_case2() {
        printAllSubStrings("hello")
    }

    companion object {
        var count = 0
    }
}