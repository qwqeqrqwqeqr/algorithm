package baekjoon.problem2644


import java.util.*
import kotlin.collections.ArrayList


fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val n = nextInt(); nextLine() // 전체 사람의 수
    val src = nextInt();
    val dst = nextInt(); nextLine()
    val m = nextInt(); nextLine()
    val tempList: ArrayList<Int> = arrayListOf()
    val degreeList: Array<Degree> = Array(n + 1) { Degree(arrayListOf()) }
    for (i in 1..m) {
        var tempsSrc = nextInt()
        var tempDst = nextInt()
        degreeList[tempDst].edge.add(tempsSrc)
        degreeList[tempsSrc].edge.add(tempDst)
    }
//
//    degreeList.forEachIndexed { index, degree ->
//        println("index  $index")
//        degree.edge.forEach {
//            print("$it   ")
//        }
//        println()
//    }

    print(bfs(src, dst, n, tempList, degreeList))
}


fun bfs(src: Int, dst: Int, size: Int, tempList: kotlin.collections.ArrayList<Int>, degreeList: Array<Degree>): Int {
    var queue: Queue<Int> = LinkedList<Int>();
    val visited: Array<Boolean> = Array(size = size + 1) { false }
    var count = 1
    queue.offer(src)
    visited.fill(false)
    visited[src] = true

    while (!queue.isEmpty() || tempList.isNotEmpty()) {

        if (queue.isEmpty()) {
            tempList.forEach { queue.offer(it) }
            count += 1
            tempList.clear()
        }
        var node = queue.poll();

        degreeList[node].edge.forEach {
            if(it==dst){ return count }
            if (!visited[it]) {
                tempList.add(it);
                visited[it] = true;
            }
        }
    }
    queue.clear()
    return -1
}

data class Degree(var edge: java.util.ArrayList<Int>)