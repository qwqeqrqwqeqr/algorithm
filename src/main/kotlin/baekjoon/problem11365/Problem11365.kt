package baekjoon.problem11365

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    while (true){
        val cypher = readLine()
        if(cypher=="END") break
        else println(cypher.reversed())
    }
}