package com.noorifytech.algorithms.namcc.tree

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

class DiameterOfBinaryTree {

    private fun diameter(node: BNode<Int>?): Int {
        if (node == null) return 0

        val myDiameter = 1 + maxPath(node.left) + maxPath(node.right) // 6
        val leftDiameter = diameter(node.left) // 7
        val rightDiameter = diameter(node.right) // 1

        return max(myDiameter, max(leftDiameter, rightDiameter))
    }

    private fun maxPath(node: BNode<Int>?): Int {
        if (node == null) return 0
        val left = maxPath(node.left)
        val right = maxPath(node.right)

        return 1 + max(left, right)
    }

    @Test
    fun case1() {
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
        Assert.assertEquals(4, diameter(root))
    }

    @Test
    fun case2() {
        // Arrange
        /**
         *            0
         *          /  \
         *         4    5
         *       /   \
         *     1      2
         *    / \    /  \
         *   7   8  9    1
         *      /  /
         *     3  5
         */
        val root = BNode(
            data = 0,
            left = BNode(
                data = 4,
                left = BNode(
                    data = 1,
                    left = BNode(
                        data = 7,
                        left = null,
                        right = null
                    ),
                    right = BNode(
                        data = 8,
                        left = BNode(
                            data = 3,
                            left = null,
                            right = null
                        ),
                        right = null
                    )
                ),
                right = BNode(
                    data = 2,
                    left = BNode(
                        data = 9,
                        left = BNode(data = 5),
                        right = null
                    ),
                    right = BNode(
                        data = 1,
                        left = null,
                        right = null
                    )
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
        Assert.assertEquals(7, diameter(root))
    }
}