package baekjoon.problem3584

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()

    repeat(T) {
        val N = readLine().toInt()
        val treeList = Array(N + 1) { EdgeList(arrayListOf()) }
        val parentList: Array<Int> = Array(N + 1) { 0 }
        repeat(N - 1) {
            readLine().split(' ').map { it.toInt() }.toList().also {
                treeList[it[0]].edge.add(it[1])
                parentList[it[1]] = it[0]
            }
        }
        val M = readLine().split(' ').map { it.toInt() }.toList()
        val root = findRoot(parentList)
        var targetA = Target(M[0], findDepth(M[0], treeList, 0, root))
        var targetB = Target(M[1], findDepth(M[1], treeList, 0, root))

        //높이를 맞춘다.
        if (targetA.depth >= targetB.depth) {
            targetA = setDepth(targetA, targetB.depth,parentList)
        } else {
            targetB = setDepth(targetB, targetA.depth,parentList)
        }

        println(LCA(targetA,targetB,parentList))

    }
}

fun LCA(targetA: Target, targetB: Target, parentList: Array<Int>): Int {
    var targetANode =targetA.node
    var targetBNode =targetB.node
    while (true){
        if(targetANode==targetBNode){
            return targetANode
        }
        targetBNode = parentList[targetBNode]
        targetANode = parentList[targetANode]
    }
}

fun setDepth(target: Target, depth: Int,parentList: Array<Int>): Target {
    var tempNode = target.node
    repeat(target.depth-depth){ tempNode = parentList[tempNode] }
    return Target(tempNode,depth)
}

fun findRoot(parentList: Array<Int>): Int {
    for (node in 1..parentList.size) {
        if (parentList[node] == 0) {
            return node
        }
    }
    return -1
}

fun findDepth(target: Int, treeList: Array<EdgeList>, depth: Int, currentNode: Int): Int {
    if (currentNode == target) {
        return depth
    }
    if (treeList[currentNode].edge.isEmpty()) {
        return 0
    }
    var targetDepth = 0
    treeList[currentNode].edge.forEach {
        val temp = findDepth(target, treeList, depth + 1, it)
        if (temp != 0) {
            targetDepth = temp
        }
    }
    return targetDepth
}

data class EdgeList(var edge: java.util.ArrayList<Int>)

data class Target(var node: Int, var depth: Int)