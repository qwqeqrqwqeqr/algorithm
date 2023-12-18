package baekjoon.problem10773

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val arrayList = arrayListOf<Int>()
    repeat(readLine().toInt()) {
        val item =readLine().toInt()
        if(item==0){
            arrayList.removeAt(arrayList.size-1)
        }
        else{
            arrayList.add(item)
        }
    }
    println(arrayList.sum())
}