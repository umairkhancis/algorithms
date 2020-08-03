package com.noorifytech.algorithms.namcc.recursion

import org.junit.Test

class ExpressionCreator {
    private fun createExpression(input: String, operators: List<String>) {
        if (input.isEmpty()) return
        createExpression(input, 1, input[0].toString(), false, operators, operators[0])
    }

    private fun createExpression(
        input: String,
        index: Int,
        output: String,
        isLastOperator: Boolean,
        operators: List<String>,
        operator: String
    ) {
//        23
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
    fun createExpression_case() {
        createExpression("", listOf("*", "+"))
    }

    @Test
    fun createExpression_case2() {
        createExpression("1234", listOf("*", "+"))
    }

    companion object {
        var count = 0
    }
}