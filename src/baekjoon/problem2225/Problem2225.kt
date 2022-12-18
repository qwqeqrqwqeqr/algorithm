package baekjoon.problem2225

import javax.swing.text.html.HTML.Attribute.N


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    val map = Array(201) { IntArray(201) }


    for (n in 1..input[0]) { map[0][n] = 1 }

    for (k in 1..input[1]) { map[k][0] = 1 }

    for (i in 1 .. input[1]){
        for(j in 1 .. input[0]){
            map[i][j] = (map[i][j-1]+map[i-1][j])%1000000000
        }
    }


    println(map[input[1]-1][input[0]])


}