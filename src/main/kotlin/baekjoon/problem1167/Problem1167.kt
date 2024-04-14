package baekjoon.problem1167

var deepNode = Node()
val visited = BooleanArray(100_001) { false }

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val v = readLine().toInt()
    val graph = Array(v + 1) { ArrayList<Pair<Int, Int>>() }

    repeat(v) {
        val input = readLine().split(" ").map { it.toInt() }.dropLast(1)
        for (i in 0 until input.size / 2) {
            graph[input[0]].add(input[(i * 2) + 1] to input[(i * 2 + 1) + 1])
        }
    }

    dfs(v, Node(), graph)
    visited.fill(false)
    dfs(v, deepNode.copy(length = 0), graph)
    println(deepNode.length)
}


fun dfs(
    v: Int,
    node: Node,
    graph: Array<ArrayList<Pair<Int, Int>>>,
) {
    visited[node.number] = true
    if (deepNode.length < node.length) deepNode = node

    graph[node.number].forEach { target ->
        if (!visited[target.first]) {
            visited[target.first] = true
            dfs(
                v,
                Node(
                    number = target.first,
                    length = node.length + target.second,
                ), graph
            )
        }
    }

}


data class Node(
    val number: Int = 1,
    var length: Int = 0,
)

