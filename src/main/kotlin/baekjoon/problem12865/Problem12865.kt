package baekjoon.problem12865


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N,K) = readLine().split(" ").map { it.toInt() }
    val arrayList = ArrayList<Product>().apply {
        this.add(Product(0,0))
    }
    val dp = Array(N+1) { IntArray(K+1) { 0 } }
    repeat(N){
        readLine().split(" ").map { it.toInt() }.apply { arrayList.add(Product(this[0],this[1])) }
    }

    /*
       - 행렬 전환해서 판단 할 것 (목표 수용량의 도달 했을 때 얻을 수 있는 최고가치를 얻어야 하기 때문)
       해당 무게에서 담을 수 없을 경우
        => 위에 것을 끌고옴
       해당 무게에서 담을 수 있을 경우
        => 위에 무게에서 얻는 가치와  현재 무게의 가치 + 현재 무게의 차이 만큼 남은 무게로 부터 얻을 수 있는 가치 중 최대 값을 끌고옴
     */

    for(i in 1 ..  K){
        for(j in 1 .. N){
            if(arrayList[j].weight > i){
                dp[j][i] =  dp[j-1][i]
            }
            else{
                dp[j][i] = Math.max(dp[j-1][i - arrayList[j].weight] + arrayList[j].value  ,  dp[j-1][i]);
            }
        }
    }
    println(dp[N][K])
}


data class Product(val weight: Int, val value: Int)
