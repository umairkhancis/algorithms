package com.nooListtech.algorithms.namcc

import org.junit.Test

class PowerSet {
    private fun printPowerSet(arr: IntArray) {
        print("{")
        printPowerSet(arr, 0, "")
        print("}")
    }

    private fun printPowerSet(arr: IntArray, inputIndex: Int, result: String) {
        if (inputIndex == arr.size) {
            printOutput(result)
            return
        }

        val op1 = result  // don't select
        val op2 = result + arr[inputIndex] // select

        printPowerSet(arr, inputIndex+1, op1)
        printPowerSet(arr, inputIndex+1, op2)
    }

    private fun printOutput(result: String) {
        print("{")
        for (i in result.indices) {
            print("${result[i]}")
            if (i != result.length - 1)
                print(",")
        }
        print("}, ")
    }

    @Test
    fun powerSet_case1() {
        printPowerSet(intArrayOf(1, 2, 3))
    }
}