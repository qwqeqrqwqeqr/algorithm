package programmers.greedy.joystick




class JoyStick {
    fun solution(name: String): Int {
        var string: StringBuilder = java.lang.StringBuilder()
        var left =0
        var right = 0
        repeat(name.length){ string.append("A") }
        while (!name.equals(string)){
            while(name[left]!='A' || name[right]!='A'){
                left++
                right--
            }
        }


        return 0
    }
}
fun main() {
    val joyStick = JoyStick()
    val name = "JAZ"
    println(joyStick.solution(name))
}