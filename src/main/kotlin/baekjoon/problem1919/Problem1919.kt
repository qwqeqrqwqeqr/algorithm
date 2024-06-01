package baekjoon.problem1919

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val a = readLine().toMutableList()
    val b = readLine().toMutableList()

    for (i in b.indices) {
        for (j in a.indices) {
            if (b[i] == a[j]) {
                a[j] = '#'
                b[i] = '#'
                break
            }
        }
    }
    println(a.count { it !='#' }+b.count { it !='#' })
}