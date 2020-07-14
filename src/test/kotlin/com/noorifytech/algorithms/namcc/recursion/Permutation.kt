package com.noorifytech.algorithms.namcc.recursion

import org.junit.Test

class Permutation {
    private fun permutations(str: String) {
        generatePermutations(str.toCharArray(), 0)
    }

    private fun generatePermutations(str: CharArray, index: Int) {
        if (index == str.size) {
            println(str)
            return
        }

        for (i in index until str.size) {
            str.swap(i, index)
            generatePermutations(str, index + 1)
            str.swap(i, index)
        }
    }

    @Test
    fun permutations_case1() {
        permutations("ABC")
    }
}

fun CharArray.swap(src: Int, dest: Int) {
    val temp = this[src]
    this[src] = this[dest]
    this[dest] = temp
}