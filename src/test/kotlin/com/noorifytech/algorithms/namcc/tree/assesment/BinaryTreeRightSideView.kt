package com.noorifytech.algorithms.namcc.tree.assesment

import com.noorifytech.algorithms.namcc.tree.BNode
import org.junit.Test

class BinaryTreeRightSideView {
    private fun binaryTreeRightSideView(node: BNode<Int>?): ArrayList<Int> {
        return solve(node, ArrayList())
    }

    private fun solve(node: BNode<Int>?, result: ArrayList<Int>): ArrayList<Int> {
        if (node == null) {
            return result
        }

        result.add(node.data)
        solve(node.right, result)

        return result
    }

    @Test
    fun case1() {
        // Arrange
        /**
         *            1
         *          /  \
         *         2    3
         *          \    \
         *           5    4
         */
        val root = BNode(
            data = 1,
            left = BNode(
                data = 2,
                left = null,
                right = BNode(data = 5)
            ),
            right = BNode(
                data = 3,
                left = null,
                right = BNode(data = 4)
            )
        )

        val result = binaryTreeRightSideView(root)
        println("BinaryTreeRightSideView.case1: $result")
    }
}