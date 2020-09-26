package com.noorifytech.algorithms.namcc.tree.assesment

import com.noorifytech.algorithms.namcc.tree.BNode
import com.noorifytech.algorithms.namcc.tree.InOrderTraversal
import org.junit.Test

class ConvertSortedArrayToBinarySearchTree {
    private fun convertSortedArrayToBST(arr: List<Int>): BNode<Int>? {
        if (arr.isEmpty()) return null
        return insert(arr, 0, arr.size - 1, null)
    }

    private fun insert(arr: List<Int>, start: Int, end: Int, node: BNode<Int>?): BNode<Int>? {
        if (start > end) {
            return node
        }

        val mid = (start+end) / 2
        return BNode(
            data = arr[mid],
            left = insert(arr, 0, mid - 1, node),
            right = insert(arr, mid + 1, end, node)
        )
    }

    @Test
    fun case1() {
        // Arrange
        val arr: Array<Int> = arrayOf(-10, -3, 0, 5, 9)

        val root = convertSortedArrayToBST(arr.toList())

        InOrderTraversal().inOrder(root)
    }
}