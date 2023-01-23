package baekjoon.problem1422

var maxDigits = 1

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (k,n) = readLine().split(" ").map { it.toInt() }
    var tempList = ArrayList<Int>()
    var answer =""
    repeat(k){ tempList.add(readLine().toInt()) }
    var arrayList= tempList.sortedDescending()
    val maxNumber =arrayList[0]

    tempList.forEach { maxDigits=lcm(maxDigits,it.toString().length) }

    arrayList= arrayList.sortedWith(
        compareByDescending<Int> {  fillDigits(it.toString().length,it) }
    )

    arrayList.subList(0,arrayList.indexOf(maxNumber)).forEach { answer+=it }
    answer += maxNumber.toString().repeat((n-k))
    arrayList.subList(arrayList.indexOf(maxNumber),arrayList.size).forEach { answer+=it }


    print(answer)
}
fun fillDigits(digits:Int,number:Int): String {
    return  number.toString().repeat(maxDigits/digits)
}
fun gcd(a: Int, b:Int): Int = if(b != 0) gcd(b, a % b) else a
fun lcm(a:Int,b:Int) =a * b / gcd(a, b)

/*

 */

