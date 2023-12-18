package baekjoon.problem10699

import java.time.LocalDate

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(LocalDate.now().apply { "${year-monthValue-dayOfMonth}" })
}