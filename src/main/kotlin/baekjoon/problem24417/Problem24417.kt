package baekjoon.problem24417


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()

    var a = 1
    var b = 1
    var temp = 0

    for (i in 3..input) {
        temp = b;
        b = (a + b) % 1000000007
        a = temp;
    }
    println("${b % 1000000007} ${(input - 2) % 1000000007}")
}

/**
 * 1 1
 * 2 1
 * 3 2
 * 4 3
 * 5 5
 * 6 8
 */