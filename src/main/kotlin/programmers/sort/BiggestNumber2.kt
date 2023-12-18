package programmers.sort
import kotlin.math.log10

class BiggestNumber2 {
    fun solution(numbers: IntArray): String {
        var answer = ""
        val arrayList = ArrayList<Number>()
        var temp =1
        if(numbers.checkZeroList()){
            return "0"
        }
        numbers.forEach {
                arrayList.add(Number(it))
                temp = lcm(temp,it.getLength())
        }
        arrayList.forEach {
            while(temp!=it.new.length){
                it.new= it.new.plus(it.old.toString())
            }
        }
        println(temp)
        arrayList.sortByDescending { it.new.toBigInteger() }
        arrayList.forEach { answer+=it.old.toString() }
        return answer
    }
}
data class Number(val old:Int, var new: String="")
fun Int.getLength():Int = if(this>0) (log10(this.toDouble()) +1).toInt() else 1
fun IntArray.checkZeroList():Boolean{
    this.forEach { if(it!=0){ return false } }
    return  true
}
fun lcm(n:Int, m:Int):Int = n * m / gcd(n, m)
fun gcd(n:Int, m:Int):Int{
    return if(n < m){
        if(n == 0) m else gcd(n, m % n)
    }else{
        if(m == 0) n else gcd(m, n % m)
    }
}


fun main() {
    val solution = BiggestNumber2()
    val intArray = intArrayOf(0,11,111,1111,11111,11111,1111111,11111111,111111111,1111111111,1111111111)
    println(solution.solution(intArray))
}

