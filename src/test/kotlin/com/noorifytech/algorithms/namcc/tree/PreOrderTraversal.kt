package com.noorifytech.algorithms.namcc.tree

import org.junit.Test

class PreOrderTraversal {
    // Curr Node, Left Node, Right Node
    private fun preOrder(node: BNode<Int>?) {
        if (node == null) return

        print(" ${node.data} ")
        preOrder(node.left)
        preOrder(node.right)
    }

    @Test
    fun case1() {
        // Arrange
        /**
         *            1
         *          /  \
         *         2    3
         *      /    \
         *     4      5
         */
        val root = BNode(
            data = 1,
            left = BNode(
                data = 2,
                left = BNode(
                    data = 4,
                    left = null,
                    right = null
                ),
                right = BNode(
                    data = 5,
                    left = null,
                    right = null
                )
            ),
            right = BNode(
                data = 3,
                left = null,
                right = null
            )
        )

        preOrder(root)
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

        preOrder(root)
    }
}