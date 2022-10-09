package baekjoon.problem11047


val coin : ArrayList<Int> = arrayListOf()
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    repeat(input[0]){ coin.add(readLine().toInt()) }
    coin.reverse()
    var sum =0
    var depth =0
    while (true){
        if(sum==input[1]){ break }
        for ( i in 0 until  coin.size) {
            if(coin[i]+sum > input[1]){ continue } else{
                depth++
                sum += coin[i]
                break
            }
        }
    }
    println(depth)
}




