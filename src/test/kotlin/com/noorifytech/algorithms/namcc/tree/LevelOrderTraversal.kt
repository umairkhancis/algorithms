package com.noorifytech.algorithms.namcc.tree

import org.junit.Test
import java.util.*

class LevelOrderTraversal {

    fun levelOrder(node: BNode<Int>?) {
        if (node == null) {
            return
        }

        val queue: Deque<BNode<Int>> = LinkedList()
        queue.offer(node)
        while (queue.isNotEmpty()) {
            val currNode = queue.first
            if (currNode.left != null) queue.offer(currNode.left)
            if (currNode.right != null) queue.offer(currNode.right)

            print(" ${queue.poll().data} ")
        }
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

        levelOrder(root)
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

        levelOrder(root)
    }
}