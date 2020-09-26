package com.noorifytech.algorithms.noorifytech

import org.junit.Test

class PowerSet {

    private fun powerSet(arr: Array<Int>) {
        solve(arr, 0, "")
    }

    private fun solve(arr: Array<Int>, index: Int, output: String) {
        if (index == arr.size) {
            println("{$output}")
            return
        }

        // two possibilities - select, don't select
        solve(arr, index + 1, output)
        solve(arr, index + 1, output + arr[index])
    }

    @Test
    fun case1() {
        powerSet(arrayOf(1, 2, 3))
    }
}