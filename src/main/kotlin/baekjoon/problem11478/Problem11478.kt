package baekjoon.problem11478

import java.util.HashSet
import java.util.LinkedHashSet

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine()
    val hashSet: HashSet<String> = LinkedHashSet()

    for (i in input.indices) {
        for (j in 0..i) {
            hashSet.add(input.slice(j..i))
        }
    }

    println(hashSet.size)
}
