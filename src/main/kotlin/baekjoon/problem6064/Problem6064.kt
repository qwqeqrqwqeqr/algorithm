package baekjoon.problem6064

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val calendar = readLine().split(" ").map { it.toInt() }.let { Calendar(it[0], it[1], it[2], it[3]) }
        val maxValue = lcm(calendar.M, calendar.N)

        var target = calendar.x
        var result = -1

        while (target <= maxValue) {
            val targetY = if(target % calendar.N ==0) calendar.N else target % calendar.N
            if (targetY == calendar.y) {
                result = target
                break
            }
            target += calendar.M
        }

        println(result)
    }
}

fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a
fun lcm(a: Int, b: Int) = a * b / gcd(a, b)
data class Calendar(
    val M: Int,
    val N: Int,
    val x: Int,
    val y: Int,
)