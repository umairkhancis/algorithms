package com.noorifytech.algorithms.namcc.linkedlist

import org.junit.Assert
import org.junit.Test
import java.util.*

class LruCacheTest() {
    @Test
    fun case1() {
        // Arrange
        val cache = LruCache<String, Int>(3)
        cache.set("Umair", 3)
        cache.set("Aamir", 1)
        cache.set("Maria", 2)

        cache.printCache()

        // Act
        cache.set("Usman", 4)

        // Assert
        cache.printCache()
        Assert.assertEquals(cache.map.size, 3)
    }
}

class LruCache<KEY, VALUE>(private var capacity: Int) {
    private var head: Node<KEY, VALUE>? = null
    private var tail: Node<KEY, VALUE>? = null
    val map: HashMap<KEY, Node<KEY, VALUE>> = HashMap()

    fun set(key: KEY, value: VALUE) {
        val newNode = Node(key, value)

        if (this.map.size >= capacity) {
            val tail = this.tail
            this.tail = tail?.prev
            map.remove(tail?.key)
        }

        addFront(newNode)

        map[key] = newNode
    }

    private fun addFront(newNode: Node<KEY, VALUE>) {
        val head = this.head
        newNode.next = head
        newNode.prev = null
        this.tail = head?.next
        this.tail?.prev = head?.next
        this.head = newNode
    }


    fun get(key: KEY): VALUE? {
        return map[key]?.data
    }

    fun remove(key: KEY): VALUE {
        TODO()
    }

    fun printCache() {
        for (node in map) {
            println("${node.key}: ${node.value.data}")
        }

        var node = this.head
        while (node != null) {
            print("${node.key}:${node.data} -> ")
            node = node.next
        }

        println("\n================================")
    }
}

data class Node<KEY, VALUE>(
    val key: KEY,
    val data: VALUE,
    var next: Node<KEY, VALUE>? = null,
    var prev: Node<KEY, VALUE>? = null
)