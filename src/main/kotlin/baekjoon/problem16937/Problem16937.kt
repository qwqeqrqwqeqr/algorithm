package baekjoon.problem16937

var max = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val map = readLine().split(" ").map { it.toInt() }
    val N = readLine().toInt()
    val sticker = Array(N + 1) { Area(0, 0) }
    val visited = BooleanArray(N + 1) { false }

    repeat(N) {
        readLine().split(" ").map { it.toInt() }.apply {
            sticker[it + 1] = Area(this[0], this[1])
        }
    }

    for (i in 1 until sticker.size) {
            visited[i] = true
            dfs(1, visited, sticker, sticker[i], sticker[i].getArea(), Area(map[0], map[1]))
            dfs(1, visited, sticker, sticker[i].change(), sticker[i].getArea(), Area(map[0], map[1]))
            visited[i] = false
    }
    println(max)
}

fun dfs(depth: Int, visited: BooleanArray, sticker: Array<Area>, area: Area, sum: Int, map: Area) {
    if (depth == 2) {
        max = sum.coerceAtLeast(max); return
    }
    for (i in 1 until sticker.size) {
        if (!visited[i]) {
            if ((Math.max(
                    sticker[i].height,
                    area.height
                ) <= map.height && (sticker[i].width + area.width <= map.width)) ||
                (Math.max(
                    sticker[i].width,
                    area.width
                ) <= map.width && (sticker[i].height + area.height <= map.height))
            ) {
                visited[i] = true
                dfs(
                    depth + 1,
                    visited,
                    sticker,
                    Area(sticker[i].width + area.width, sticker[i].height + area.height),
                    sum + sticker[i].getArea(),
                    map
                )
                visited[i] = false
            }
            if ((Math.max(
                    sticker[i].change().height,
                    area.height
                ) <= map.height && (sticker[i].change().width + area.width <= map.width)) ||
                (Math.max(
                    sticker[i].change().width,
                    area.width
                ) <= map.width && (sticker[i].change().height + area.height <= map.height))
            ) {
                visited[i] = true
                dfs(
                    depth + 1,
                    visited,
                    sticker,
                    Area(sticker[i].change().width + area.width, sticker[i].change().height + area.height),
                    sum + sticker[i].getArea(),
                    map
                )
                visited[i] = false
            }
        }
    }
}

fun Area.getArea() = this.width * this.height

fun Area.change() = Area(this.height, this.width)
data class Area(var width: Int, var height: Int)