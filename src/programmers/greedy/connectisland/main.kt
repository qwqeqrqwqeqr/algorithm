package programmers.greedy.connectisland

fun main() {
    var n : Int = 5
    var costs = Array(5, {IntArray(3)})
    costs[0]= intArrayOf(0,1,1)
    costs[1]= intArrayOf(0,2,2)
    costs[2]= intArrayOf(0,3,3)
    costs[3]= intArrayOf(0,4,4)
    costs[4]= intArrayOf(1,3,1)
    val connectIsland = ConnectIsland()
    System.out.println(connectIsland.solution(n,costs))
}