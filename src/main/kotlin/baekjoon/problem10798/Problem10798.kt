package baekjoon.problem10798

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val array = Array(5) { CharArray(15) { '@' } }
    val bufferWriter = System.out.bufferedWriter()
    repeat(5) { row ->
        readLine().forEachIndexed { column, value ->
            array[row][column] = value
        }
    }
    for(i in 0 until 15){
        for(j in 0 until  5){
            if(array[j][i]!='@'){
                bufferWriter.append("${array[j][i]}")
            }
        }
    }
    bufferWriter.flush()
}