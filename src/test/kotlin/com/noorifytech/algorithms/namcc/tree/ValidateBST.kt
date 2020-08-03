package com.noorifytech.algorithms.namcc.tree

import org.junit.Assert
import org.junit.Test

class ValidateBST {
    private fun isBST(node: BNode<Int>?): Boolean {
        if (node == null) {
            return true
        }

        if (node.left != null && node.left.data > node.data) {
            return false
        }

        if (node.right != null && node.right.data < node.data) {
            return false
        }

        return isBST(node.left) && isBST(node.right)
    }

    @Test
    fun isBST_case1() {
        // Arrange
        /**
         *            4
         *          /  \
         *         2    5
         *      /    \
         *     1      3
         */
        val root = BNode(
            data = 4,
            left = BNode(
                data = 2,
                left = BNode(
                    data = 1,
                    left = null,
                    right = null
                ),
                right = BNode(
                    data = 3,
                    left = null,
                    right = null
                )
            ),
            right = BNode(
                data = 5,
                left = null,
                right = null
            )
        )

        // Act
        // Assert
        Assert.assertTrue(isBST(root))
    }

    @Test
    fun isBST_case2() {
        // Arrange
        /**
         *            0
         *          /  \
         *         4    5
         *      /    \
         *     1      2
         */
        val root = BNode(
            data = 0,
            left = BNode(
                data = 4,
                left = BNode(
                    data = 1,
                    left = null,
                    right = null
                ),
                right = BNode(
                    data = 2,
                    left = null,
                    right = null
                )
            ),
            right = BNode(
                data = 5,
                left = null,
                right = null
            )
        )

        // Act
        // Assert
        Assert.assertFalse(isBST(root))
    }
}