package baekjoon.problem10451


import java.util.*


fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val T = nextInt(); nextLine()
    var answer : ArrayList<Int> = arrayListOf()
    for(i in 1 .. T){
        val N =nextInt();
        val nodeList: Array<EdgeList> = Array(N+1){EdgeList(arrayListOf())}
        for (j in 1..N) {
            var src = nextInt()
            var dst = j
            nodeList[src].edge.add(dst)
            nodeList[dst].edge.add(src)
        }
        nodeList.forEachIndexed { index, node ->
            node.edge.sort()
        }
        val visited : Array<Boolean> = Array(size = N+1){false}
        var cycle =0
        for(start in 1 .. N){
            if(!visited[start]){
                cycle+=1
                bfs(start,visited,nodeList)
            }
        }
        answer.add(cycle)
    }


    answer.forEach {
        print("$it ")
    }

}


fun bfs(start : Int, visited: Array<Boolean>,nodeList: Array<EdgeList>) {
    var que : Queue<Int> = LinkedList<Int>();
    que.offer(start)
    visited[start] = true

    while( !que.isEmpty() ) {
        var node = que.poll();
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