package baekjoon.problem2217

import java.lang.Math.max


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var answer = Int.MIN_VALUE
    val input = readLine().toInt()
    var rope = arrayListOf<Int>()
    repeat(input) {
        readLine().toInt().apply { rope.add(this) }
    }
    rope.sortedDescending().also {
        it.forEachIndexed { index, i ->
            answer = max(i * (index + 1), answer)
        }
    }
    println(answer)
}


//2개라 가정
// 1, 2, 12
//3개라 가정
// 1, 2, 3, 12, 13, 23 ,123