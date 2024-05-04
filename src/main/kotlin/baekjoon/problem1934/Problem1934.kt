package baekjoon.problem1934

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferWriter = System.out.bufferedWriter()
   repeat(readLine().toInt()){
       val (a,b) = readLine().split(" ").map { it.toInt() }
       bufferWriter.append("${lcm(a,b)} \n")
   }
    bufferWriter.flush()
}

fun gcd(a: Int, b:Int): Int = if(b != 0) gcd(b, a % b) else a
fun lcm(a:Int,b:Int) =a * b / gcd(a, b)