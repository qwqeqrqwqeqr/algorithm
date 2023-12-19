package baekjoon.problem2609

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(readLine().split(" ").map { it.toInt() }.let {
        "${gcd(it[0],it[1])}\n${lcm(it[0],it[1])}"
    })
}

fun gcd(a: Int, b:Int): Int = if(b != 0) gcd(b, a % b) else a
fun lcm(a:Int,b:Int) =a * b / gcd(a, b)