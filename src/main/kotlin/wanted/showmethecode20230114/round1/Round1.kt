package wanted.showmethecode20230114.round1


//왼쪽 1 오른쪽 -1
//금칠을 해서 얻을 수 있는 깨달음 양
//인접한 동상에만 칠할 수 있음

var max = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val input = readLine().toInt()
    val list = readLine().split(' ').map { it.toInt() }.map { if (it == 1) 1 else -1 }.toIntArray()
    max = maxOf(list.sum(), max)
    for(i in list.indices){
        paint(list.copyOf(),i)
    }
    println(max)
}
fun paint(list: IntArray, i: Int) {
    list[i]=0
    max = maxOf(list.sum(), max)
    if(i>0 && list[i-1] !=0){ paint(list.copyOf(),i-1)}
    if(i<list.size-1 && list[i+1] !=0){ paint(list.copyOf(),i+1) }
}


