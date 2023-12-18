package baekjoon.problem8979

import java.util.*
import kotlin.collections.ArrayList

data class Medal(val code: Int ,val gold: Int, val silver: Int, val bronze: Int, var rank: Int)

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var rank =1
    val count =nextInt()
    val targetCountry =nextInt();
    val countryList: ArrayList<Medal> = java.util.ArrayList()
    for (i in 1..count) {
        countryList.add(Medal(nextInt(),nextInt(),nextInt(),nextInt(),0))
    }

    countryList.sortWith(compareByDescending<Medal> { it.gold }.thenByDescending { it.silver }.thenByDescending { it.bronze })




    for(i in 0 until countryList.size) {
        if(countryList[i].rank!=0) {continue}
        else{countryList[i].rank=rank}
        for(j in i+1 until countryList.size) {
            if(countryList[i].bronze==  countryList[j].bronze
                &&countryList[i].silver==  countryList[j].silver
                &&countryList[i].gold==  countryList[j].gold
            ){
                if(countryList[j].rank==0){
                    countryList[j].rank=rank
                }
            }
        }
        rank += 1
    }

    countryList.forEach {
        println("code"+ it.code + "  gold" + it.gold + "  silver" +it.silver + "  bronze" + it.bronze + "  rank" + it.rank)
    }

    countryList.forEach { medal ->
        if(medal.code==targetCountry) {
            print(medal.rank)
        }
    }

}
