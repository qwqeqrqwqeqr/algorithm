package baekjoon.problem1436

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    readLine().toInt().apply {
        var number = 0
        var count =0
        while (true) {
            if (this == count) {
                println(number)
                break
            }
            number++
            if(number.toString().contains("666")){
                count++
            }
        }
    }
}