package baekjoon.problem1043

val unf = IntArray(51) { it }


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val truePerson = ArrayList<Int>()
    val partyList = Array(m) { emptyList<Int>() }
    readLine().split(" ").map { it.toInt() }.drop(1).forEach { truePerson.add(it) }
    repeat(m) {
        val party = readLine().split(" ").map { it.toInt() }.drop(1)
        partyList[it] = party
        if (party.size > 1) {
            for (i in 1 until party.size) {
                union(party[0], party[i])
            }
        }
    }


    println(truePerson.map { find(it) }.let {  tList ->
        partyList.count {
            it.map { find(it) }.none { tList.contains(it) }
        }
    })

}


fun find(v: Int): Int {
    return if (v == unf[v]) v
    else find(unf[v])
}

fun union(v: Int, w: Int) {
    val a = find(v)
    val b = find(w)
    if (a < b) unf[b] = a
    else unf[a] = b
}