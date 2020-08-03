package com.noorifytech.algorithms.namcc.tree

data class BNode<T>(
    val data: T,
    val left: BNode<T>? = null,
    val right: BNode<T>? = null
)

data class TreeNode<T>(
    val data: T,
    val children: Array<TreeNode<T>> = emptyArray()
)