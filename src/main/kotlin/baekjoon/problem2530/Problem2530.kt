package baekjoon.problem2530

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var (h, m, s) = readLine().split(" ").map { it.toInt() }
    s += readLine().toInt()

    m+=s/60
    h+=m/60
    h%=24
    m%=60
    s%=60

    println("$h $m $s")
}