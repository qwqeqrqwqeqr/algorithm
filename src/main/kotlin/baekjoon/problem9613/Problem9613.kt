package baekjoon.problem9613

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = System.out.bufferedWriter()
    repeat(readLine().toInt()) {
        val list = readLine().split(" ").map { it.toLong() }.drop(1)
        var sum = 0L
        for (i in list.indices) {
            for (j in i + 1 until list.size) {
                sum += gcd(list[i], list[j])
            }
        }
        bufferedWriter.append("$sum\n")
    }
    bufferedWriter.flush()
}


fun gcd(a: Long, b: Long): Long = if (b != 0L) gcd(b, a % b) else a
