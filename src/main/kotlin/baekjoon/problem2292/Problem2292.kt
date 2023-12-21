package baekjoon.problem2292

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine().toInt().run {
        if(this==1){
            println(1)
            return@run
        }
        var min = 1
        var max = 6
        for (i in 1..300_000_000) {
            if (this in  min+1 .. max+1) {
                println("${i + 1}")
                break
            }
            min += 6 * i
            max += 6 * (i + 1)
        }
    }
}
