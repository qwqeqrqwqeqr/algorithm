package baekjoon.problem1296

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val name = readLine()
    val n = readLine().toInt()
    val array = Array<Pair<String, Int>?>(n) { null }
    repeat(n) {
        val team = readLine()
        val L = name.count { it == 'L' } + team.count { it == 'L' }
        val O = name.count { it == 'O' } + team.count { it == 'O' }
        val V = name.count { it == 'V' } + team.count { it == 'V' }
        val E = name.count { it == 'E' } + team.count { it == 'E' }
        array[it] = team to ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100
    }
    println(
        array.sortedWith(
            comparator = compareByDescending<Pair<String, Int>?> { it!!.second }.thenComparing(compareBy { it!!.first })
        ).first()!!.first
    )
}


