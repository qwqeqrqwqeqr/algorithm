package baekjoon.problem2884


import java.util.Scanner




fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var H = nextInt()
    var M = nextInt()


    if(M < 45){
       if(H==0){ H=23;  M += 15 }
       else{ H -= 1; M += 15
       }
    }
    else{
        M-=45
    }
    print("$H $M")
}