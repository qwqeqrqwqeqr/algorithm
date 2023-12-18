package baekjoon.problem16234

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1)
var day = 0

/*
1.모든 경우에 대해서 BFS를 돌필요가 없다.
2.visited를 union에 포함되어있던 국가들은 어차피 다음 bfs에도 반영해야하기 때문에 false로 세팅함
3.평균값의 갱신으로 기존에 visited true 였던 이웃한 국가가 연합이 될 수 있는데, 해당 국가는 순환을 마치면 false로 바뀌면서 다음 반복때 bfs의 대상이 된다.
 */

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    val arrayList: MutableList<MutableList<Int>> = arrayListOf(arrayListOf())
    repeat(input[0]) { arrayList.add(readLine().split(" ").map { it.toInt() }.toList() as MutableList<Int>) }
    arrayList.removeAt(0)
    var visited: HashSet<Pair<Int, Int>> = hashSetOf<Pair<Int, Int>>().also {
        for (i in 0 until input[0]) {
            for (j in 0 until input[0])
                it.add(Pair(i, j))
        }
    }

    while (true) {
        var totalUnionSet: ArrayList<HashSet<Pair<Int, Int>>> =
            arrayListOf<HashSet<Pair<Int, Int>>>(hashSetOf()).also { it.clear() }
        var avgList: ArrayList<Int> = arrayListOf()
        var queue: Queue<Pair<Int, Int>> = LinkedList()
        visited.forEach {
            var total = 0
            var unionSet: HashSet<Pair<Int, Int>> = hashSetOf()


            queue.add(Pair(it.first, it.second))
            unionSet.add(Pair(it.first, it.second))
            visited.add(Pair(it.first, it.second))
            total += arrayList[it.first][it.second]


            while (queue.isNotEmpty()) {
                val country = queue.poll()
                for (direction in 0 until 4) {
                    if (!unionSet.contains(
                            Pair(
                                country.first + dy[direction],
                                country.second + dx[direction]
                            )
                        ) && checkBound(
                            country.first + dy[direction],
                            country.second + dx[direction],
                            input[0]
                        ) && checkRange(
                            input[1],
                            input[2],
                            abs(arrayList[country.first][country.second] - arrayList[country.first + dy[direction]][country.second + dx[direction]])
                        )
                    ) {

                        unionSet.add(Pair(country.first + dy[direction], country.second + dx[direction]))
                        queue.add(Pair(country.first + dy[direction], country.second + dx[direction]))
                        visited.add(Pair(country.first + dy[direction], country.second + dx[direction]))
                        total += arrayList[country.first + dy[direction]][country.second + dx[direction]]
                    }
                }
            }
            if (unionSet.isNotEmpty() && unionSet.size != 1) {
                totalUnionSet.add(unionSet)
                avgList.add(total / unionSet.size)
            }

        }

        if (totalUnionSet.isEmpty()) {
            break
        }
        //배열 평균 값 할당
        totalUnionSet.forEachIndexed { index, it ->
            it.forEach { country ->
                arrayList[country.first][country.second] = avgList[index]
            }
        }
        day += 1
    }
    print(day)
}

//연합에 포함시킬조건
fun checkRange(min: Int, max: Int, target: Int): Boolean = target in min..max

//범위
fun checkBound(y: Int, x: Int, N: Int): Boolean {
    return (0 <= x && 0 <= y && x < N && y < N)
}