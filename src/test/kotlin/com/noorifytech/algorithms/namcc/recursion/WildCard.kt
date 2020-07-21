package com.noorifytech.algorithms.namcc.recursion

import org.junit.Assert
import org.junit.Test

class WildCard {
    private fun wildCard(input: String): ArrayList<String> {
        return wildCard(input, 0, "", arrayListOf())
    }

    private fun wildCard(input: String, index: Int, tempOutput: String, result: ArrayList<String>): ArrayList<String> {
        if (index == input.length) {
            println(tempOutput)
            result.add(tempOutput)
            return result
        }

        if (input[index] == '?') {
            wildCard(input, index + 1, tempOutput + "0", result)
            wildCard(input, index + 1, tempOutput + "1", result)
        } else {
            wildCard(input, index + 1, tempOutput + input[index], result)
        }

        return result
    }


    @Test
    fun wildCard_case1() {
        Assert.assertEquals(listOf("0", "1"), wildCard("?"))
    }

    @Test
    fun wildCard_case2() {
        Assert.assertEquals(listOf("10", "11"), wildCard("1?"))
    }

    @Test
    fun wildCard_case3() {
        Assert.assertEquals(listOf("100", "101"), wildCard("10?"))
    }

    @Test
    fun wildCard_case4() {
        Assert.assertEquals(listOf("1000", "1001", "1100", "1101"), wildCard("1?0?"))
    }
}