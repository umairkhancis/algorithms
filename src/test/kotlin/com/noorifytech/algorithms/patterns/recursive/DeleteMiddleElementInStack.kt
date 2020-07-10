package com.noorifytech.algorithms.patterns.recursive

import org.junit.Assert
import org.junit.Test
import java.util.*

class DeleteMiddleElementInStack {

    private fun deleteMiddleElementInStack(stack: Stack<Int>): Stack<Int> {
        val middle = stack.size / 2 + 1
        return delete(stack.clone() as Stack<Int>, middle)
    }

    private fun delete(stack: Stack<Int>, position: Int): Stack<Int> {
        var pos = position
        if (pos == 1) {
            stack.pop()
            return stack
        }

        val last = stack.pop()
        pos -= 1
        delete(stack, pos)
        stack.push(last)

        return stack
    }

    @Test
    fun deleteMiddleElementInStack_case1() {
        // Arrange
        val stack = Stack<Int>()
        stack.push(7)
        stack.push(4)
        stack.push(1)
        stack.push(6)
        stack.push(0)
        stack.push(9)

        // Act
        val result = deleteMiddleElementInStack(stack)

        // Assert
        println("Input stack = $stack")
        println("output stack = $result")
        Assert.assertEquals(result.toList(), listOf(7, 4, 6, 0, 9))
    }
}