package com.noorifytech.algorithms.namcc.recursion.assessment

import org.junit.Assert
import org.junit.Test

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
"cats and dog",
"cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
"pine apple pen apple",
"pineapple pen apple",
"pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */
class WordBreak {

    fun wordBreak(str: String, dict: HashSet<String>): List<String> {
        return wordBreak(str, dict, 0, "", "", arrayListOf())
    }

    fun wordBreak(
        str: String,
        dict: HashSet<String>,
        start: Int,
        seenSoFar: String,
        temp: String,
        finalResult: ArrayList<String>
    ): ArrayList<String> {
        if (start == str.length) {
            val allWords = seenSoFar.split(" ")
            val allNonDictWords = allWords.filter { !dict.contains(it) }
            if (allNonDictWords.isEmpty()) {
                finalResult.add(seenSoFar)
            }

            return finalResult
        }

        val op = seenSoFar + str[start]
        val word = temp + str[start]
        if (dict.contains(word)) {
            wordBreak(str, dict, start + 1, op + " ", "", finalResult)
            wordBreak(str, dict, start + 1, op, word, finalResult)
        } else {
            wordBreak(str, dict, start + 1, op, word, finalResult)
        }

        return finalResult
    }

    @Test
    fun case1() {
        val dict = hashSetOf("cat", "cats", "and", "sand", "dog")
        val sentences = wordBreak("catsanddog", dict)
        println(sentences)
        Assert.assertEquals(2, sentences.size)
    }

    @Test
    fun case2() {
        val dict = hashSetOf("apple", "pen", "applepen", "pine", "pineapple")
        val sentences = wordBreak("pineapplepenapple", dict)
        println(sentences)
        Assert.assertEquals(3, sentences.size)
    }

    @Test
    fun case3() {
        val dict = hashSetOf("cats", "dog", "sand", "and", "cat")
        val sentences = wordBreak("catsandog", dict)
        println(sentences)
        Assert.assertEquals(0, sentences.size)
    }
}