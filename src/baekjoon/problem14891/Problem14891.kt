package baekjoon.problem14891


val clock_index = arrayOf(0, 2, 4, 6)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var gearList: ArrayList<Gear> = arrayListOf()
    val inputList: ArrayList<Pair<Int, Boolean>> = arrayListOf()
    val tempList :ArrayList<Gear> =ArrayList<Gear>()
    for (i in 1..4) {
        gearList.add(Gear(i, readLine().toList().map { Character.getNumericValue(it) } as ArrayList<Int>))
        tempList.add(Gear(i, arrayListOf()))
    }

    val N = readLine().toInt()
    repeat(N) {
        val temp = readLine().split(" ").map { it.toInt() }.toList()
        inputList.add(Pair(temp[0], temp[1]==1))
    }

    inputList.forEach {
        when (it.first) {
            1 ->{
                firstTransaction(tempList, gearList,it.second)
            }
            2 -> {
                secondTransaction(tempList, gearList,it.second)
            }
            3 ->{
                thirdTransaction(tempList, gearList,it.second)
            }
            else ->{
                forthTransaction(tempList, gearList,it.second)
            }
        }
        for(i in 0 until 4){
            if(tempList[i].status.isNotEmpty()){
                gearList[i].status = tempList[i].status.clone() as ArrayList<Int>
                tempList[i].status.clear()
            }
        }
    }
    println(getTotal(gearList))

}

/*
Param
direction
0 : left (source기준 target의 위치)
1 : right (source기준 target의 위치)
 */
//: ArrayList<Int>
fun checkStatus(source: ArrayList<Int>, target: ArrayList<Int>, direction: Int): Boolean {
    when (direction) {
        0 -> {
            if (target[clock_index[1]] == source[clock_index[3]]) {
                return false
            }
        }

        1 -> {
            if (target[clock_index[3]] == source[clock_index[1]]) {
                return false
            }
        }
    }
   return true
}

fun rotate(gear: ArrayList<Int>, rotate: Boolean): ArrayList<Int> {
    val tempList : ArrayList<Int> = gear.clone() as ArrayList<Int>
    if (rotate) {
        tempList.add(0, tempList.last())
        tempList.removeAt(tempList.size - 1)
    } else {
        tempList.add(gear.size, tempList.first())
        tempList.removeAt(0)
    }
    return tempList
}

fun getTotal(gearList: ArrayList<Gear>):Int{
    var total =0
    gearList.forEach {
        if(it.num==1&&it.status[clock_index[0]] == 1){
            total+=1
        }
        if(it.num==2&&it.status[clock_index[0]] == 1){
            total+=2
        }
        if(it.num==3&&it.status[clock_index[0]] == 1){
            total+=4
        }
        if(it.num==4&&it.status[clock_index[0]] == 1){
            total+=8
        }
    }
    return total
}





fun firstTransaction(tempList: ArrayList<Gear>, gearList: ArrayList<Gear>, rotate: Boolean){
    tempList[0].status = rotate(gearList[0].status,rotate)
    if (checkStatus(gearList[0].status,gearList[1].status,1)){
        tempList[1].status = rotate(gearList[1].status,!rotate)
    }else{return}
    if (checkStatus(gearList[1].status,gearList[2].status,1)){
        tempList[2].status = rotate(gearList[2].status,rotate)
    }else{return}
    if (checkStatus(gearList[2].status,gearList[3].status,1)){
        tempList[3].status = rotate(gearList[3].status,!rotate)
    }else{return}
}






fun secondTransaction(tempList:ArrayList<Gear>,gearList:ArrayList<Gear>, rotate: Boolean){
    tempList[1].status = rotate(gearList[1].status,rotate)
    if (checkStatus(gearList[1].status,gearList[0].status,0)){
        tempList[0].status = rotate(gearList[0].status,!rotate)
    }
    if (checkStatus(gearList[1].status,gearList[2].status,1)){
        tempList[2].status = rotate(gearList[2].status,!rotate)
    }else{return}
    if (checkStatus(gearList[2].status,gearList[3].status,1)){
        tempList[3].status = rotate(gearList[3].status,rotate)
    }else{return}
}
fun thirdTransaction(tempList:ArrayList<Gear>,gearList:ArrayList<Gear>, rotate: Boolean){
    tempList[2].status = rotate(gearList[2].status,rotate)
    if (checkStatus(gearList[2].status,gearList[3].status,1)){
        tempList[3].status = rotate(gearList[3].status,!rotate)
    }
    if (checkStatus(gearList[2].status,gearList[1].status,0)){
        tempList[1].status = rotate(gearList[1].status,!rotate)
    }else{return}
    if (checkStatus(gearList[1].status,gearList[0].status,0)){
        tempList[0].status = rotate(gearList[0].status,rotate)
    }else{return}
}
fun forthTransaction(tempList:ArrayList<Gear>,gearList:ArrayList<Gear>, rotate: Boolean){
    tempList[3].status = rotate(gearList[3].status,rotate)
    if (checkStatus(gearList[3].status,gearList[2].status,0)){
        tempList[2].status = rotate(gearList[2].status,!rotate)
    }else{return}
    if (checkStatus(gearList[2].status,gearList[1].status,0)){
        tempList[1].status = rotate(gearList[1].status,rotate)
    }else{return}
    if (checkStatus(gearList[1].status,gearList[0].status,0)){
        tempList[0].status = rotate(gearList[0].status,!rotate)
    }else{return}
}

data class Gear(val num: Int, var status: ArrayList<Int>)