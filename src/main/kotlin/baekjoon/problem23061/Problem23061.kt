package baekjoon.problem23061

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val weightArray = IntArray(N + 1) { 0 }
    val valueArray = IntArray(N + 1) { 0 }
    val knapsackArray = IntArray(M + 1) { 0 }
    repeat(N) {
       readLine().split(" ").map { it.toInt() }.also { product ->
           weightArray[it+1] = product[0]
           valueArray[it+1] = product[1]
       }
    }
    repeat(M) { knapsackArray[it+1] =readLine().toInt() }
    val dp = Array(N+1) { IntArray(knapsackArray.max()+1) { 0 } }
    for(i in  1 .. N){
        for(j in 1 .. knapsackArray.max()){
            if(j < weightArray[i]){ dp[i][j] = dp[i-1][j] }
            else{
                dp[i][j] = dp[i - 1][j].coerceAtLeast(dp[i - 1][j - weightArray[i]] + valueArray[i])
            }
        }
    }
   println(knapsackArray.drop(1).mapIndexed { index, i -> Pair(index+1,dp[N][i]/i.toDouble()) }.maxBy { it.second }.first)
}
