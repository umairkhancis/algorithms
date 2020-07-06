package com.noorifytech.algorithms.crackingthecodinginterview.arrays

/**
 * Approaches:
 * 1- Compare anagrams of both strings; anagrams means char freq map. O(N) and O(N)
 * 2- Compare freq array of both strings; anagrams using array instead of map. O(N) and O(N)
 * 3- Sort both the strings and match them char by char. O(NlogN) and O(1)
 */
class CheckTwoStringsArePermutationOfEachOther {

    fun arePermutations(): Boolean {
        return true
    }
}