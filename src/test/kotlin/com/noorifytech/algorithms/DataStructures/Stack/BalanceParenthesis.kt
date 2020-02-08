package com.noorifytech.algorithms.DataStructures.Stack

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BalanceParenthesis {

    private fun isBalanced(exp: String): Boolean {
        val stack = Stack<Char>()
        val openingBraces = arrayListOf('(', '{', '[')
        val closingBraces = arrayListOf(')', '}', ']')
        val pairs = hashMapOf('(' to ')', '{' to '}', '[' to ']')

        for (char in exp) {
            if (char in openingBraces) {
                stack.push(char)
            } else if (char in closingBraces && stack.isNotEmpty() && pairs[stack.peek()] == char) {
                stack.pop()
            }
        }

        return stack.isEmpty()
    }

    @Test
    fun test_isBalanced_1() {
        Assert.assertTrue(isBalanced("(A+B)"))
    }

    @Test
    fun test_isBalanced_2() {
        Assert.assertTrue(isBalanced("{A+B}"))
    }

    @Test
    fun test_isBalanced_3() {
        Assert.assertTrue(isBalanced("[A+B]"))
    }

    @Test
    fun test_isBalanced_4() {
        Assert.assertTrue(isBalanced("[(a-b) * c - {d + (e -f)} ]"))
    }

    @Test
    fun test_isBalanced_5() {
        Assert.assertFalse(isBalanced("[(a-b) * c - {d + (e -f) ]"))
    }

    @Test
    fun test_isBalanced_6() {
        Assert.assertFalse(isBalanced(")("))
    }

    @Test
    fun test_isBalanced_7() {
        Assert.assertFalse(isBalanced("([{(}]"))
    }

    @Test
    fun test_isBalanced_8() {
        Assert.assertTrue(isBalanced("3+2*6"))
    }
}
