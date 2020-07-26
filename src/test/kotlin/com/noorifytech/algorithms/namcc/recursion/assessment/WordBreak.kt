package com.noorifytech.algorithms.namcc.recursion.assessment

import org.junit.Assert
import org.junit.Test

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