package baekjoon.problem11723

import java.io.BufferedWriter
import java.io.OutputStreamWriter

val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val set = HashSet<Int>()

    repeat(readLine().toInt()) {
        readLine().split(" ").apply {
            when (this[0]) {
                "add" -> {
                    add(set, this[1].toInt())
                }

                "remove" -> {
                    remove(set, this[1].toInt())
                }

                "check" -> {
                    bufferedWriter.append(check(set, this[1].toInt()))
                }

                "toggle" -> {
                    toggle(set, this[1].toInt())
                }

                "all" -> {
                    all(set)
                }

                "empty" -> {
                    empty(set)
                }
            }
        }
    }
    bufferedWriter.flush()
}

fun add(set: HashSet<Int>, value: Int) {
    set.add(value)
}

fun remove(set: HashSet<Int>, value: Int) {
    set.remove(value)
}

fun check(set: HashSet<Int>, value: Int): String {
    return if (set.contains(value)) "1\n" else "0\n"
}

fun toggle(set: HashSet<Int>, value: Int) {
    if (set.contains(value)) set.remove(value) else set.add(value)
}

fun all(set: HashSet<Int>) {
    (1..20).forEach { set.add(it) }
}

fun empty(set: HashSet<Int>) {
    set.clear()
}

