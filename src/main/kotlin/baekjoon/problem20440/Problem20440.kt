package baekjoon.problem20440


/*
시간 초과
 */
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val map = HashMap<Int,Int>()
    repeat(N){
        val (s,e) = readLine().split(" ").map { it.toInt() }
        map[s]= map.getOrDefault(s,0)+1
        map[e]=map.getOrDefault(e,0)-1
    }
    var minTerm=0 ;var maxTerm=0
    var flag= false; var count =0
    var item =0
    map.keys.sorted().forEach{ it ->
        count += map.getOrDefault(it,0)
        if(count > item){
            item=count;minTerm=it;flag=true
        }
        else if(count < item && flag){
            maxTerm=it;flag=false
        }
    }
    bufferedWriter.append(item.toString()+"\n")
    bufferedWriter.append((minTerm).toString()+" "+(maxTerm).toString())
    bufferedWriter.flush()
}


