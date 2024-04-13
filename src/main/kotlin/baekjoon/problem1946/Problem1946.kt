package baekjoon.problem1946

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val employeeList: ArrayList<Pair<Int, Int>> = arrayListOf()

        repeat(readLine().toInt()) {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            employeeList.add(a to b)
        }
        employeeList.sortBy { it.first }
        var count = 1
        var target = employeeList.first()
        employeeList.forEachIndexed { index, pair ->
            if(target.second > pair.second){
                count+=1
                target = pair
            }
        }
        println(count)
    }
}