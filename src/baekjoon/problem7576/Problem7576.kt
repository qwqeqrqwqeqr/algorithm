package baekjoon.problem7576

import java.util.*
import kotlin.collections.ArrayList


val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1) //상우하좌
var M: Int = 0
var N: Int = 0

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    M = nextInt() //행
    N = nextInt() //열
    nextLine()
    val tomatoList: ArrayList<java.util.ArrayList<Int>> = arrayListOf(arrayListOf())
    val queue: Queue<Coordinate> = LinkedList<Coordinate>();
    val tempList : ArrayList<Coordinate> = arrayListOf()
    var day :Int =0

    for (i in 1 ..  N) {
        val tempArray = arrayListOf<Int>()
        for (j in 0 until M) {
            val tomato = nextInt()
            if (tomato == 1) {
                queue.offer(Coordinate(i, j))
            }
            tempArray.add(tomato)
        }
        tomatoList.add(tempArray)
    }

    while (!queue.isEmpty() || tempList.isNotEmpty()) {
        if(queue.isEmpty()){
            tempList.forEach { queue.offer(Coordinate(it.y,it.x))  }
            day+=1 //depth
            tempList.clear()
        }

        val tomatoCoordinate = queue.poll();
        check(tomatoList,tempList ,tomatoCoordinate.y, tomatoCoordinate.x)
    }


    if(checkNotVisited(tomatoList)){
        println("-1")
    }else{
        println(day)
    }


}
fun checkNotVisited(tomatoList: ArrayList<java.util.ArrayList<Int>>):Boolean{
    tomatoList.forEach {
        it.forEach { if(it==0)
            return true
        }
    }
    return false
}

data class Coordinate(val y: Int, val x: Int)

fun checkBound(y: Int, x: Int): Boolean { return (0 <= x && 0 < y && x < M && y <= N) }

fun check(tomatoList: ArrayList<java.util.ArrayList<Int>>,tempList : ArrayList<Coordinate>, y: Int, x: Int) {
    for (i in 0..3) {
        if ( checkBound(y + dy[i], x + dx[i]) ) {
            if(tomatoList[y + dy[i]][x + dx[i]] == 0) {
                tomatoList[y + dy[i]][x + dx[i]] = 1;
                tempList.add(Coordinate(y + dy[i], x + dx[i]))
            }
        }
    }
}

// 넓이 우선탐색으로 한층씩 깊어지는게 하루일것이다.
// 상하좌우에 있는 것들을 queue에 포함시킴 이때 0인것들만 포함한다
// 최종적으로 queue가 비면 마무리


//배열 검사코드
//tomatoList.forEach {
//    it.forEach {
//        print("$it ")
//    }
//    println()
//}