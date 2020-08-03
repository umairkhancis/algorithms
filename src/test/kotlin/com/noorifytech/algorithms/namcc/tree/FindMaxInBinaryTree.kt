package com.noorifytech.algorithms.namcc.tree

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

class FindMaxInBinaryTree {
    private fun maxInBinaryTree(node: BNode<Int>?): Int {
        if (node == null) {
            throw IllegalArgumentException("Empty Tree!")
        }

        return maxInBinaryTree(node, node.data)
    }

    private fun maxInBinaryTree(node: BNode<Int>?, currMax: Int): Int {
        if (node == null) {
            return currMax
        }

        val leftMax = maxInBinaryTree(node.left, currMax)
        val rightMax = maxInBinaryTree(node.right, currMax)

        return max(node.data, max(leftMax, rightMax))
    }

    @Test
    fun maxInBinaryTree_case1() {
        // Arrange
        /**
         *        0
         *       / \
         *      4   5
         *      /\  /\
         *     1 2  3
         */
        val n1 = BNode<Int>(1)
        val n2 = BNode<Int>(2)
        val n3 = BNode<Int>(3)
        val n4 = BNode<Int>(4, n1, n2)
        val n5 = BNode<Int>(5, n3)
        val root = BNode<Int>(0, n4, n5)

        // Act
        // Assert
        Assert.assertEquals(5, maxInBinaryTree(root))
    }

    @Test
    fun maxInBinaryTree_case2() {
        // Arrange
        /**
         *        0
         *       / \
         *      4   5
         *      /\  /\
         *     1 2  3
         */
        val n1 = BNode<Int>(1)
        val n2 = BNode<Int>(2)
        val n3 = BNode<Int>(3)
        val n4 = BNode<Int>(4, n1, n2)
        val n5 = BNode<Int>(5, n3)
        val root = BNode<Int>(0, n4, n5)

        // Act
        // Assert
        Assert.assertEquals(5, maxInBinaryTree(root))
    }

    @Test(expected = IllegalArgumentException::class)
    fun maxInBinaryTree_whenEmptyTree() {
        // Arrange
        // Act
        // Assert
        maxInBinaryTree(null)
    }
}