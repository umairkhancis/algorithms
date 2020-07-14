package com.noorifytech.algorithms.namcc.recursion

import org.junit.Assert
import org.junit.Test

class PowerSet {
    private fun powerSet(arr: IntArray): String {
        val powerSet = generatePowerSet(arr, 0, "", StringBuilder())
        return format(powerSet)
    }

    private fun generatePowerSet(arr: IntArray, inputIndex: Int, subSet: String, finalSet: StringBuilder): String {
        if (inputIndex == arr.size) {
            return format(subSet, finalSet).toString()
        }

        generatePowerSet(arr, inputIndex + 1, subSet, finalSet) // don't select
        generatePowerSet(arr, inputIndex + 1, subSet + arr[inputIndex], finalSet) // select

        return finalSet.toString()
    }

    private fun format(powerSet: String) = "{ " + powerSet.removeRange(powerSet.length - 2, powerSet.length) + " }"

    private fun format(subSet: String, finalSet: StringBuilder): StringBuilder {
        finalSet.append("{")
        for (i in subSet.indices) {
            finalSet.append("${subSet[i]}")
            if (i != subSet.length - 1)
                finalSet.append(",")
        }
        finalSet.append("}, ")

        return finalSet
    }

    @Test
    fun powerSet_case1() {
        val result = powerSet(intArrayOf(1, 2, 3))
        println(result)
        Assert.assertEquals("{ {}, {3}, {2}, {2,3}, {1}, {1,3}, {1,2}, {1,2,3} }", result)
    }

    @Test
    fun powerSet_case2() {
        val result = powerSet(intArrayOf(1, 2, 3, 4))
        println(result)
        Assert.assertEquals(
            "{ {}, {4}, {3}, {3,4}, {2}, {2,4}, {2,3}, {2,3,4}, {1}, {1,4}, {1,3}, {1,3,4}, {1,2}, {1,2,4}, {1,2,3}, {1,2,3,4} }",
            result
        )
    }
}