package baekjoon.problem2798


var result = Int.MIN_VALUE
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(N) { -1 }
    val visited = BooleanArray(N) { false }
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i -> array[index] = i }
    dfs(0, M, 0, array, visited)

    println(result)
}


fun dfs(current: Int, total: Int, depth: Int, array: IntArray, visited: BooleanArray) {
    if (depth == 3 && current <= total) {
        result = current.coerceAtLeast(result)
        return
    }
    if(current>total) return

    array.forEachIndexed { index, i ->
        if(!visited[index]) {
            visited[index] = true
            dfs(current+i,total,depth+1,array,visited)
            visited[index] = false
        }
    }
}