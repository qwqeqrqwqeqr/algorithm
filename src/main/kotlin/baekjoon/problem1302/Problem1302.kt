package baekjoon.problem1302

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val map = HashMap<String, Int>()

    repeat(readLine().toInt()) {
        readLine().also { title ->
            map[title] = map.getOrDefault(title, 0) + 1
        }
    }
    val max = map.maxOf { it.value }
    print(map.filter { it.value == max }.toSortedMap().firstKey())
}