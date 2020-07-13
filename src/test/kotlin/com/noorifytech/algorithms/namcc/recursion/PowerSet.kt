package com.noorifytech.algorithms.namcc.recursion

import org.junit.Assert
import org.junit.Test

class PowerSet {
    private fun powerSet(arr: IntArray): String {
        val powerSet = generatePowerSet(arr, 0, "", StringBuilder())
        return format(powerSet)
    }

    private fun generatePowerSet(arr: IntArray, inputIndex: Int, oneSet: String, finalSet: StringBuilder): String {
        if (inputIndex == arr.size) {
            return format(oneSet, finalSet).toString()
        }

        generatePowerSet(arr, inputIndex + 1, oneSet, finalSet) // don't select
        generatePowerSet(arr, inputIndex + 1, oneSet + arr[inputIndex], finalSet) // select

        return finalSet.toString()
    }

    private fun format(powerSet: String) = "{ " + powerSet.removeRange(powerSet.length - 2, powerSet.length) + " }"

    private fun format(oneSet: String, finalSet: StringBuilder): StringBuilder {
        finalSet.append("{")
        for (i in oneSet.indices) {
            finalSet.append("${oneSet[i]}")
            if (i != oneSet.length - 1)
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