package baekjoon.problem9506

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = System.out.bufferedWriter()
    while (true) {
        val value = readLine().toInt()
        val set = HashSet<Int>()
        if (value == -1) break
        set.add(1)
        for (i in 2 until value) {
            if (value % i == 0) {
                set.add(i)
                set.add(value / i)
            }
        }
        if (set.sum() == value) bufferedWriter.append("$value = ${set.sorted().joinToString(" + ")}\n")
        else bufferedWriter.append("$value is NOT perfect.\n")
    }
    bufferedWriter.flush()
}