package com.noorifytech.algorithms.namcc.recursion

import org.junit.Test

class AllSubstring {
    private fun printAllSubStrings(str: String) {
        for (i in str.indices) {
            printAllSubStrings(str, i + 1, true, str[i].toString())
        }
    }

    private fun printAllSubStrings(str: String, index: Int, selected: Boolean, output: String) {
        if (index == str.length) {
            println(output)
            return
        }

        val op1 = output
        val op2 = output + str[index]

        if (!selected) {
            printAllSubStrings(str, str.length, false, op1)
        } else {
            printAllSubStrings(str, index + 1, false, op1)
            printAllSubStrings(str, index + 1, true, op2)
        }
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