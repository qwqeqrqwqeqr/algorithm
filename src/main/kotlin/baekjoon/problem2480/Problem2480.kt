package baekjoon.problem2480

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (a, b, c) = readLine().split(" ").map { it.toInt() }

    println(
        if (a == b && b == c) 10_000+a*1_000
        else if(a==b)  1_000+a*100
        else if(b==c)  1_000+b*100
        else if(c==a)  1_000+c*100
        else Math.max(Math.max(a,b),c) * 100
    )
}