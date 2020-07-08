package com.noorifytech.algorithms.mit

import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import kotlin.math.acos
import kotlin.math.sqrt

/**
 * Given two documents as string
 *
 *
 * Document similarities are measured based on the content overlap between documents. With the large number of text
 * documents in our life, there is a need to automatically process those documents for information extraction,
 * similarity clustering, and search applications. There exist a vast number of complex algorithms to solve this problem.
 * One of such algorithms is a cosine similarity - a vector based similarity measure. The cosine distance of two
 * documents is defined by the angle between their feature vectors which are, in our case, word frequency vectors.
 *
 * The word frequency distribution of a document is a mapping from words to their frequency count.
 *
 * Read More:
 * https://www.andrew.cmu.edu/course/15-121/labs/HW-4%20Document%20Distance/lab.html
 */
class DocumentDistance {

    /**
     * Calculates the distance between two documents
     * Here, distance between two documents mean how much words they share in common.
     *
     * @return angle between their word frequency vectors.
     */
    private fun distance(doc1: String, doc2: String): Double {

        val d1 = getVector(doc1)
        val d2 = getVector(doc2)
        val dotProduct12 = dotProduct(d1, d2)
        val magnitude12 = sqrt((dotProduct(d1, d1) * dotProduct(d2, d2)).toDouble())

        return acos(dotProduct12 / magnitude12)
    }

    @Ignore
    @Test
    fun test_distance_1() {
        Assert.assertEquals(0.0,
            distance("Umair Umair Ahmed Khan", "Umair Ahmed Khan"),
            0.000001
        )
    }

    @Test
    fun test_distance_2() {
        Assert.assertEquals(Math.PI / 2,
            distance("Umair Ahmed Khan", "Faizan Iftikhar"),
            0.000001
        )
    }

    @Test
    fun test_distance_3() {
        Assert.assertEquals(1.23095942,
            distance("Umair Ahmed Khan", "Hassan Hameed Khan"),
            0.000001
        )
    }



    @Ignore
    @Test
    fun test_distance_4() {
        Assert.assertEquals(0.0,
            distance(
                DOC1,
                DOC2
            ),
            0.000001
        )
    }

    /**
     * Get frequency
     */
    private fun getVector(doc: String): Map<String, Int> {
        val words = doc.split(" ")
        val vector = mutableMapOf<String, Int>()
        for (word in words) {
            vector[word] = vector[word]?.plus(1) ?: 1
        }

        return vector
    }

    private fun dotProduct(v1: Map<String, Int>, v2: Map<String, Int>): Int {
        var dotProduct = 0
        for (word in v1.keys) {
            if (v2.containsKey(word)) {
                dotProduct += v1[word]?.times(v2[word] ?: 0) ?: 0
            }
        }

        return dotProduct
    }

    companion object {
        const val DOC1 = "2019-07-21 10:24:05.733 1207-1235/? I/ActivityManager: Displayed com.dubizzle.horizontal/.activities.MainActivity: +5s32ms"

        const val DOC2 = "2019-07-21 10:26:07.151 1207-1235/? I/ActivityManager: Displayed com.dubizzle.horizontal/.activities.MainActivity: +5s25ms\n"
    }
}
