package com.noorifytech.algorithms.Talabat

import org.junit.Assert
import org.junit.Test
import java.util.*

class PartitionLinkedList {
    private fun partition(list: LinkedList<Int>, k: Int) {
        if (list.isEmpty()) return

        val last = list.removeLast()
        partition(list, k)

        if (last < k) {
            list.addBefore(k, last)
        } else if (last > k) {
            list.addLast(last)
        } else {
            list.addBeforeAnyGreaterThan(k, last)
        }
    }

    @Test
    fun partition_case1() {
        // Arrange
        val list = LinkedList<Int>()
        val out = LinkedList<Int>()
        list.addLast(5); list.addLast(3); list.addLast(1); list.addLast(2);list.addLast(4)
        out.addLast(1); out.addLast(2); out.addLast(3); out.addLast(5); out.addLast(4)
        println("input: $list")

        // Act
        partition(list, 3)

        // Assert
        println("output: $list")
        Assert.assertEquals(out, list)
    }

    @Test
    fun partition_case2() {
        // Arrange
        val list = LinkedList<Int>()
        val out = LinkedList<Int>()
        list.addLast(1); list.addLast(4); list.addLast(3); list.addLast(2); list.addLast(5); list.addLast(2)
        out.addLast(1); out.addLast(2); out.addLast(2); out.addLast(3); out.addLast(4); out.addLast(5)
        println("input: $list")

        // Act
        partition(list, 3)

        // Assert
        println("output: $list")
        Assert.assertEquals(out, list)
    }
}

private fun LinkedList<Int>.addBefore(key: Int, value: Int) {
    val pos = indexOf(key)
    if (pos >= 0) this.add(pos, value) else this.addFirst(value)
}

private fun LinkedList<Int>.addBeforeAnyGreaterThan(key: Int, value: Int) {
    for (el in this) {
        if(el > key) {
            this.addBefore(el, value)
            return
        }
    }
}