package baekjoon.problem14916

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()
    var count = 0
    while (n > 0) {
        if (n == 6) {
            count += 3
            break
        } else if (n == 8) {
            count += 4
            break
        } else if (n >= 5) {
            n -= 5
            count += 1
        } else if (n >= 2) {
            n -= 2
            count += 1
        }
        else{
            println(-1)
            return@with
        }
    }
    println(count)
}


/**
 * 6 -> 2* 4
 * 8-> 2 *4
 */