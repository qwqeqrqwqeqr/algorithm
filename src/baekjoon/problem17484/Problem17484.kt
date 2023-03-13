package baekjoon.problem17484

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N,M) = readLine().split(" ").map { it.toInt() }
    var array = Array(N) { IntArray(M) { 0 } }
    var fuelMap = Array(N) { Array(M) { IntArray(3) { Int.MAX_VALUE} } }  // 어느방향으로 왔는지 3 크기의 배열로 표현
    repeat(N) { i ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { j, value ->
            array[i][j] = value
        }
    }

    for(i in 0 until M){
        fuelMap[0][i][0] = array[0][i]
        fuelMap[0][i][1] = array[0][i]
        fuelMap[0][i][2] = array[0][i]
    }

    //과거에서 가장 좋았던거 선택
    //오룬쪽일 경우 왼쪽에서 온것이니, 같은 방향을 제외한 것 중 최소 선택

    for(i in 1 until  N){
        for(j in 0 until  M){
            if(j< M-1){
                fuelMap[i][j][2] = Math.min(fuelMap[i-1][j+1][0],fuelMap[i-1][j+1][1]) + array[i][j]
            }
            if(j>0){
                fuelMap[i][j][0] = Math.min(fuelMap[i-1][j-1][1],fuelMap[i-1][j-1][2]) + array[i][j]
            }
            fuelMap[i][j][1] = Math.min(fuelMap[i-1][j][0],fuelMap[i-1][j][2]) + array[i][j]

        }
    }
    var min = Int.MAX_VALUE
    fuelMap.last().forEach {
       min = Math.min(min, it.min()!!)
    }
    println(min)
}



