package com.noorifytech.algorithms.patterns.recursive

import org.junit.Assert
import org.junit.Test
import java.util.*

class ReverseStack {

    private fun reverse(stack: Stack<Int>): Stack<Int> {
        return reverse_(stack.clone() as Stack<Int>)
    }

    // 1,2,3,4,5
    // 1,2,3,4
    // 1,2,3
    // 1,2
    // 1
    // []
    private fun reverse_(stack: Stack<Int>): Stack<Int> {
        if (stack.isEmpty()) {
            return stack
        }

        val last = stack.pop()
        reverse_(stack)
        insertAt(stack, last, stack.size)

        return stack
    }

    private fun insertAt(stack: Stack<Int>, value: Int, position: Int): Stack<Int> {
        var pos = position
        if (pos == 0) {
            stack.push(value)
            return stack
        }

        val last = stack.pop()
        pos -= 1
        insertAt(stack, value, pos)
        stack.push(last)

        return stack
    }

    @Test
    fun reverseStack_case1() {
        // Arrange
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)

        // Act
        val reversedStack = reverse(stack)

        // Assert
        println("Input stack = $stack")
        println("output stack = $reversedStack")
        Assert.assertEquals(reversedStack.toList(), listOf(5, 4, 3, 2, 1))
    }
}