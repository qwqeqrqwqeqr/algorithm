package baekjoon.problem17610


var depth = 0

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    depth = readLine().toInt()
    val weightList = readLine().split(" ").map { it.toInt() }
    val S = weightList.sum()
    var visited = BooleanArray(S + 1) { false }
    dfs(weightList, 0, S, 0, visited)
    println(visited.drop(1).count { !it })
}


fun dfs(weightList: List<Int>, current: Int, sum: Int, value: Int, visited: BooleanArray) {
    if (current == depth) {
        if (value <= sum && value > 0) {
            visited[value] = true
        }
        return
    }
    dfs(weightList, current + 1, sum, value +  weightList[current], visited)
    dfs(weightList, current + 1, sum, value, visited)
    dfs(weightList, current + 1, sum, value -  weightList[current], visited)

}

