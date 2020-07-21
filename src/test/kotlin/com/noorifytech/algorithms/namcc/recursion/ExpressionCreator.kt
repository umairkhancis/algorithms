package com.noorifytech.algorithms.namcc.recursion

import org.junit.Test

class ExpressionCreator {
    private fun createExpression(input: String, operators: List<String>) {
        createExpression(input, 1, input.slice(0 until 1), false, operators, operators[0])
    }

    private fun createExpression(
        input: String,
        index: Int,
        output: String,
        isLastOperator: Boolean,
        operators: List<String>,
        operator: String
    ) {
        if (index == input.length) {
            println("${++count} \"${output}\"")
            return
        }

        val op1 = output + input[index]
        if (isLastOperator) {
            createExpression(input, index + 1, op1, false, operators, operator)
        } else {
            createExpression(input, index + 1, op1, false, operators, operator)
            for (op in operators) {
                createExpression(input, index, output + op, true, operators, operator)
            }
        }
    }

    @Test
    fun createExpression_case1() {
        createExpression("123", listOf("*", "+"))
    }

    @Test
    fun createExpression_case2() {
        createExpression("1234", listOf("*", "+"))
    }

    companion object {
        var count = 0
    }
}