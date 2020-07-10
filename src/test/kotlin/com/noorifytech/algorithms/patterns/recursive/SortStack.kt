package com.noorifytech.algorithms.patterns.recursive

import org.junit.Assert
import org.junit.Test
import java.util.*

class SortStack {

    private fun sort(stack: Stack<Int>): Stack<Int> {
        return sort_(stack.clone() as Stack<Int>)
    }

    private fun sort_(stack: Stack<Int>): Stack<Int> {
        if (stack.size <= 1) {
            return stack
        }

        val last = stack.pop()
        sort_(stack)
        insert(stack, last)

        return stack
    }

    private fun insert(stack: Stack<Int>, value: Int) {
        if (stack.isEmpty() || value >= stack.peek()) {
            stack.push(value)
            return
        }

        val last = stack.pop()
        insert(stack, value)
        stack.push(last)
    }


    @Test
    fun sortStack_case1() {
        // Arrange
        val stack = Stack<Int>()
        stack.push(7)
        stack.push(4)
        stack.push(1)
        stack.push(6)
        stack.push(0)

        // Act
        val sortedStack = sort(stack)

        // Assert
        println("Input stack = $stack")
        println("output stack = $sortedStack")
        Assert.assertEquals(sortedStack.toList(), listOf(0, 1, 4, 6, 7))
    }
}