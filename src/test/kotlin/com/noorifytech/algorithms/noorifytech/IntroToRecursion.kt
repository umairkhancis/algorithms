package com.noorifytech.algorithms.noorifytech

import org.junit.Test

// Why recursion exist =
// What is recursion = function calling it self.
// Anything that can be solved using loops, can also be solved using recursion and vice versa.

// Recursion has its upsides and downsides as well.
// Everything in computer science is a trade-off.

// - Upsides: Code is concise, code is easier to read, solution designing becomes easy, Hard to introduce bug, it is also fun, it is also cool.
// - Downsides: Hard to understand in beginning, Hard to debug, less performant than iterative solution

// Methods to solve recursive problems
// - Induction BaseCase Hypothesis = IBH => Small Input
// - Input Output Method = IP-OP => Decision Making


// Power Set Problem
// A = { a, b, c}
// P(A) = {{}, {a}, {b}, {c}, {a, b}, {a, c}, {b, c}, {a, b, c}}










class IntroToRecursion {

    /**
     * input: n, any non-negative integer
     * output: 1,2,3,....n
     *
     * n=5    1,2,3,4,5
     *
     * 1,2,3,4,5
     */
    private fun print1ToN(n: Int) {
        if (n < 1) { // second stage; base condition
            return
        }

        print1ToN(n - 1) // first stage; hypothesis
        print("$n ") // third stage;
    }

    /**
     * input: n, any non-negative integer
     * output: n,n-1,n-2,....1
     *
     * n=5    5,4,3,2,1
     *
     * 4,3,2,1
     */
    private fun printNTo1(n: Int) {
        if (n < 1) {
            return
        }
        print(n) // induction
        printNTo1(n - 1) // hypo
    }

    @Test
    fun print1ToN_case1() {
        println()
        print1ToN(5)
        println()

        println()
        print1ToN(8)
        println()
    }

    @Test
    fun printNTo1_case2() {
        println()
        printNTo1(5)
        println()

        println()
        printNTo1(8)
        println()
    }
}