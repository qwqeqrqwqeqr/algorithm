package baekjoon.problem1260

import java.util.*


fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextInt() //정점
    val M = nextInt(); //간선
    val V = nextInt(); nextLine(); //출발점
    val nodeList: Array<EdgeList> = Array(N+1){EdgeList(arrayListOf())}
    var answer : ArrayList<Int> = arrayListOf()
    val visited : Array<Boolean> = Array(size = N+1){false}
    for (i in 1..M) {
        var src = nextInt()
        var dst = nextInt()
        nodeList[src].edge.add(dst)
        nodeList[dst].edge.add(src)
    }


    nodeList.forEachIndexed { index, node ->
        node.edge.sort()
    }
    dfs(V,visited,nodeList)
    println()
    visited.fill(false)
    bfs(V,visited,nodeList)

}

fun dfs(start: Int, visited: Array<Boolean>, nodeList: Array<EdgeList>){

    visited[start] = true
    print("$start ")
    // 구현
    nodeList[start].edge.forEach {
        if (!visited[it]) {
            dfs(it,visited,nodeList)
        }
    }
}

fun bfs(start : Int, visited: Array<Boolean>,nodeList: Array<EdgeList>) {
    var que : Queue<Int> = LinkedList<Int>();
    que.offer(start)
    visited.fill(false)
    visited[start] = true

    while( !que.isEmpty() ) {
        var node = que.poll();
        print("$node ")
        nodeList[node].edge.forEach {
            if( !visited[it] ) {
                que.offer(it);
                visited[it] = true;
            }
        }
    }
    que.clear()
}
data class EdgeList(var edge: java.util.ArrayList<Int>)