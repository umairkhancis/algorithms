package com.noorifytech.algorithms.DataStructures.Stack

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExpressionEvaluator {

    private fun evaluate(exp: String): Int {
        val stack = Stack<String>()
        val operators = arrayListOf("+", "-", "*", "/")
        val postfixExp = convertToPostfix(exp)
        println("postfix = $postfixExp")
        for (c in postfixExp) {
            val char = c.toString()
            if (char !in operators) {
                stack.push(char)
            } else if (char in operators) {
                val op2 = stack.pop()
                val op1 = stack.pop()
                val res = applyOperator(op1, op2, char)
                stack.push(res.toString())
            }
        }

        return Integer.parseInt(stack.pop().toString())
    }

    private fun convertToPostfix(exp: String): String {
        var res = ""
        val stack = Stack<String>()
        val pairs = hashMapOf("(" to ")", "{" to "}", "[" to "]")
        val operators = arrayListOf("+", "-", "*", "/")

        for (c in exp) {
            val char = c.toString()
            if (char in operators || char in pairs.keys) {
                while (stack.isNotEmpty() && hasHigherPrecedence(stack.peek(), char)) {
                    res += stack.pop()
                }

                stack.push(char)
            } else if (char in pairs.values) {
                while (stack.peek() !in pairs.keys) {
                    res += stack.pop()
                }

                stack.pop()
            } else {
                res += char
            }
        }

        while (stack.isNotEmpty()) {
            res += stack.pop()
        }

        return res
    }

    private fun hasHigherPrecedence(operatorOnStack: String, currentOp: String): Boolean {
        val lowerPrecedenceOperators = arrayListOf("+", "-")
        val higherPrecedenceOperators = arrayListOf("*", "/")

        return operatorOnStack in higherPrecedenceOperators && currentOp in lowerPrecedenceOperators
    }

    private fun applyOperator(op1: String, op2: String, operator: String): Int {
        val operand1 = Integer.parseInt(op1)
        val operand2 = Integer.parseInt(op2)

        if (operator == "/" && operand2 == 0) {
            throw IllegalArgumentException("Operand2 cannot be 0 for division operation!")
        }

        return when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            else -> throw IllegalArgumentException("Unsupported operator argument!")
        }
    }

    @Test
    fun test_evaluate_1() {
        Assert.assertEquals(10, evaluate("3+2*5-1*3"))
    }

    @Test
    fun test_evaluate_2() {
        Assert.assertEquals(20, evaluate("2+3*6"))
    }

    @Test
    fun test_evaluated_3() {
        Assert.assertEquals(-1, evaluate("[3+{2-6*(3-2)}]"))
    }
}
