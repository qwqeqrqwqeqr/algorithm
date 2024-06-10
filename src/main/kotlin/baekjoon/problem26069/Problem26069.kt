package baekjoon.problem26069

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val set = HashSet<String>()
    var flag = false
    repeat(readLine().toInt()) {
        val (a, b) = readLine().split(" ")
        if (a == "ChongChong" || b == "ChongChong"){
            flag=true
            set.add(a); set.add(b)
        }
        if(flag){
            if(set.contains(a) || set.contains(b)){
                set.add(a); set.add(b)
            }
        }
    }
    println(set.size)
}