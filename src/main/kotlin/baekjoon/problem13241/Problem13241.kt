package baekjoon.problem13241

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (A,B) = readLine().split(" ").map { it.toLong() }
    println(lcm(A,B))
}

fun gcd(a: Long, b:Long): Long = if(b != 0L) gcd(b, a % b) else a
fun lcm(a:Long,b:Long) =a * b / gcd(a, b)