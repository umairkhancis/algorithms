package com.noorifytech.algorithms.namcc.recursion

import org.junit.Test

class PalindromicDecomposition {
    private fun printAllSubStrings(str: String) {
        for (i in str.indices) {
            printAllSubStrings(str, i + 1, true, str[i].toString())
        }
    }

    private fun printAllSubStrings(str: String, index: Int, selected: Boolean, output: String) {
        if (index == str.length) {
            if (isPalindrome(output)) {
                println(output)
            }
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

    private fun isPalindrome(str: String): Boolean {
        if (str.length < 2) return true
        if (str[0] != str[str.length - 1]) return false
        return isPalindrome(str.slice(1 until str.length - 1))
    }

    @Test
    fun printAllSubStrings_case1() {
        printAllSubStrings("ALi")
    }

    @Test
    fun printAllSubStrings_case2() {
        printAllSubStrings("abracadabra")
    }

    companion object {
        var count = 0
    }
}