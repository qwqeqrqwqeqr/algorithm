package baekjoon.problem1213


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val map = HashMap<Char, Int>()

    readLine().forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    if (map.count { it.value % 2 != 0 } > 1) println("I'm Sorry Hansoo")
    else {
        var mid: Char? = null
        val stringBuilder = StringBuilder()
        var point = 0
        map.toSortedMap().forEach { (t, u) ->
            var times = u
            if (u % 2 != 0) {
                mid = t
                times -= 1
            }
            repeat(times) {
                stringBuilder.insert(point, t)
            }
            point += u / 2
        }
        if (mid != null) stringBuilder.insert(point, mid)
        println(stringBuilder.toString())
    }
}
/**
 * CBCBZZAAPOP -> ABCPZOZPCBA
 */