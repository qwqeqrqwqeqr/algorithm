package baekjoon.problem4195

var unf = IntArray(200_020) { it }
var friends = IntArray(200_020) { 1 }
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = System.out.bufferedWriter()

    repeat(readLine().toInt()) { a ->
        val map = HashMap<String, Int>()

        repeat(readLine().toInt()) {
            val (a, b) = readLine().split(" ")
            map[a] = map.getOrDefault(a, map.size + 1)
            map[b] = map.getOrDefault(b, map.size + 1)

            bufferedWriter.append("${union(map[a]!!, map[b]!!)}\n")
        }

        unf = IntArray(200_020) { it }
        friends.fill(1)
        map.clear()
    }
    bufferedWriter.flush()
}


fun find(v: Int): Int {
    return if (v == unf[v]) v
    else find(unf[v])
}

fun union(v: Int, w: Int): Int {
    val a = find(v)
    val b = find(w)

    if (a != b) {
        unf[b] = a
        friends[a] += friends[b]
    }
    return friends[a]
}