package baekjoon.problem1439


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine()
    println(Math.min(calc(input,'1','0'), calc(input,'0','1')))
}


fun calc(input: String, targetA:Char,targetB:Char): Int {
    var flag = true
    var count = 0
    for (i in input.indices) {
        if (input[i] == targetA && !flag) {
            count += 1
            flag = true
            continue
        }
        if (input[i] == targetB && flag) {
            flag = false
            continue
        }
    }
    return if(!flag) count+1 else count
}


