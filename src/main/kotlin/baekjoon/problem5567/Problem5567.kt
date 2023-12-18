package baekjoon.problem5567

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val n = nextInt();  // 상근이의 동기 수
    val m = nextInt();
    nextLine(); //친구 리스트
    val relationList: Array<Relation> = Array(n + 1) { Relation(arrayListOf()) }
    for (i in 1..m) {
        var tempsSrc = nextInt()
        var tempDst = nextInt()
        relationList[tempDst].edge.add(tempsSrc)
        relationList[tempsSrc].edge.add(tempDst)
    }
    print(bfs(n, relationList))
}


fun bfs(size: Int, relationList: Array<Relation>): Int {
    var queue: Queue<Int> = LinkedList<Int>();
    val visited: Array<Boolean> = Array(size = size + 1) { false }
    visited.fill(false)
    relationList[1].edge.forEach {
        queue.offer(it)
        visited[it] = true
    }
    if(queue.isEmpty()) return 0
    while (!queue.isEmpty()) {
        var node = queue.poll();
        relationList[node].edge.forEach {
            if (!visited[it]) {
                visited[it] = true;
            }
        }
    }
    return visited.filter { it }.size-1
}

data class Relation(var edge: java.util.ArrayList<Int>)