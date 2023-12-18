package programmers.firstsearch.targetnumber


class TargetNumber {

    fun solution(numbers: IntArray, target: Int): Int {
        return calTarget(numbers.toList(),target,0)
    }

    fun calTarget(intArray: List<Int>, target: Int, number: Int):Int{
        intArray.forEach { print(it) }
        println()
        if(intArray.isEmpty()){
            if(target==number){ return 1 }
            else{ return 0 }
        }
        return  calTarget(intArray.drop(1),target,intArray[0]+number) + calTarget(intArray.drop(1),target,- intArray[0]+number)
    }
}

fun main() {
    val targetNumber = TargetNumber()
    val numbers = intArrayOf(1,1,1)
    val target = 3
    println(targetNumber.solution(numbers,target))
}
