package baekjoon.problem1967

/*
2022-12-07 진짜로 이거 왜틀린지 모르겠음

var max: Int = Int.MIN_VALUE
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val treeList = Array(N + 1) { EdgeList(arrayListOf()) }

    //데이터 입력 ,인접리스트 생성, 무방향 그래프
    repeat(N - 1) {
        readLine().split(' ').map { it.toInt() }.toList().also {
            treeList[it[0]].edge.add(Pair(it[1], it[2]))
            treeList[it[1]].edge.add(Pair(it[0], it[2]))
        }
    }
    if(N<=2){ println(0)}
    else{
        for (i in 1..N) {
            getMaxLength(i, treeList)
        }
        println(max)
    }

}

fun getMaxLength(node: Int, treeList: Array<EdgeList>) {
    //이어져있는 노드가 없으면
    if (treeList[node].edge.isEmpty()) { return }
    //모든 노드들로부터의 거리를 계산하기 위한 리스트, 0은 자기자신으로 부터 자기 자신까지의 거리
    val lengthList = arrayListOf<Int>().also { it.add(0) }
    //내 노드 기준으로 뻗어있는 노드들에 대한 거리들의 최대값을 전부 구함
    treeList[node].edge.forEach { pair ->
        lengthList.add(dfs(pair.second, pair.first, treeList,node))
    }
    lengthList.sortDescending()
    if (max <= lengthList[0] + lengthList[1]) max = lengthList[0] + lengthList[1]
}

fun dfs(currentLength: Int, currentNode: Int, treeList: Array<EdgeList>,preNode:Int): Int {
    return if (treeList[currentNode].edge.isEmpty() || treeList[currentNode].edge.size == 1) {
        currentLength
    } else {
        val list = treeList[currentNode].edge.toList().let{
            it.sortedByDescending { pair -> pair.second }.filter { pair -> pair.first != preNode }
        }
        dfs(currentLength + list[0].second, list[0].first, treeList,currentNode)
    }
}

// Pair (노드 , 가중치)
data class EdgeList(var edge: java.util.ArrayList<Pair<Int, Int>>)

 */




var maxLength: Int = 0
var maxIndex: Int = 1
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val treeList = Array(N + 1) { EdgeList(arrayListOf()) }
    var visited = Array(N+1){false}
    //데이터 입력 ,인접리스트 생성, 무방향 그래프
    repeat(N - 1) {
        readLine().split(' ').map { it.toInt() }.toList().also {
            treeList[it[0]].edge.add(Pair(it[1], it[2]))
            treeList[it[1]].edge.add(Pair(it[0], it[2]))
        }
    }
    dfs(1,0,treeList,visited)
    visited = Array(N+1){false}
    dfs(maxIndex,0,treeList, visited)
    println(maxLength)
}

fun dfs(node: Int, currentLength:Int, treeList: Array<EdgeList>, visited: Array<Boolean>) {
    if(currentLength >= maxLength){
        maxLength = currentLength
        maxIndex = node
    }
    visited[node]= true
    treeList[node].edge.forEach {
        if(!visited[it.first]){
            dfs(it.first,currentLength+it.second,treeList,visited)
        }
    }
}


data class EdgeList(var edge: java.util.ArrayList<Pair<Int, Int>>)
