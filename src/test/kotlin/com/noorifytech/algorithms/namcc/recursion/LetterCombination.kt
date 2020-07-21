package com.noorifytech.algorithms.namcc.recursion

import org.junit.Assert
import org.junit.Test

class LetterCombination {
    private fun getStringForNumber(number: Int): ArrayList<String> {
        return generateStringForNumber(number.toString(), 0, "", arrayListOf())
    }

    private fun generateStringForNumber(
        number: String,
        index: Int,
        tempOutput: String,
        result: ArrayList<String>
    ): ArrayList<String> {
        if (index == number.length) {
            result.add(tempOutput)
            return result
        }

        val digit = number[index].toString()
        val options = numPad[digit] ?: ""
        for (ch in options) {
            generateStringForNumber(number, index + 1, tempOutput + ch, result)
        }

        return result
    }

    @Test
    fun getStringForNumber_case1() {
        Assert.assertEquals(listOf("D", "E", "F"), getStringForNumber(3))
    }

    @Test
    fun getStringForNumber_case2() {
        Assert.assertEquals(listOf("P", "Q", "R", "S"), getStringForNumber(7))
    }

    @Test
    fun getStringForNumber_case3() {
        Assert.assertEquals(
            listOf(
                "ADG",
                "ADH",
                "ADI",
                "AEG",
                "AEH",
                "AEI",
                "AFG",
                "AFH",
                "AFI",
                "BDG",
                "BDH",
                "BDI",
                "BEG",
                "BEH",
                "BEI",
                "BFG",
                "BFH",
                "BFI",
                "CDG",
                "CDH",
                "CDI",
                "CEG",
                "CEH",
                "CEI",
                "CFG",
                "CFH",
                "CFI"
            ),
            getStringForNumber(234)
        )
    }

    private val numPad: HashMap<String, String> = hashMapOf(
        "1" to "",
        "2" to "ABC",
        "3" to "DEF",
        "4" to "GHI",
        "5" to "JKL",
        "6" to "MNO",
        "7" to "PQRS",
        "8" to "TUV",
        "9" to "WXYZ",
        "0" to ""
    )
}