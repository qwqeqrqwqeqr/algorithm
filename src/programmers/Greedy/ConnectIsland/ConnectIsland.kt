package programmers.Greedy.ConnectIsland

import java.util.*


class ConnectIsland {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        var max = 99999
        var island = Array<Int>(n,{max}) //집합 활성화
        costs.sortWith(
                Comparator<IntArray>{
                    c1,c2->
                    c1[2] - c2[2]
                }
       )
        for(a in costs){
            System.out.println("배열값"+ a[0]+a[1]+a[2])
        }
        island[costs[0][0]]=costs[0][0]
        island[costs[0][1]]=costs[0][0]
        answer+=costs[0][2]


        for(i in 1 until costs.size){
            System.out.println("${i+1}번째 시작")
            for(a in island){
                System.out.printf("%d/",a)
            }
            System.out.println()
            System.out.println("answer"+answer)
                if(island[costs[i][0]]==max&&island[costs[i][1]]==max) {
                    island[costs[i][0]]=costs[i][0]
                    island[costs[i][1]]=costs[i][0]
                    answer+=costs[i][2]
                }
                else if(island[costs[i][0]]!=max&&island[costs[i][1]]==max) {
                    var temp = island[costs[i][1]]
                    if(temp==max) {
                        island[costs[i][1]]=island[costs[i][0]]
                        answer+=costs[i][2]
                        continue
                    }
                    for(a in island.indices){
                        if(island[a]==temp){
                            island[a]=island[costs[i][0]]
                        }
                    }

                    answer+=costs[i][2]
                }
                else if(island[costs[i][0]]==max&&island[costs[i][1]]!=max) {
                    var temp = island[costs[i][0]]
                    if(temp==max) {
                         island[costs[i][0]]=island[costs[i][1]]
                         answer+=costs[i][2]
                         continue
                    }
                    for(a in island.indices){
                        if(island[a]==temp){
                            island[a]=island[costs[i][1]]
                        }
                    }
                    answer+=costs[i][2]
                }
                else {
                    if(island[costs[i][0]]<island[costs[i][1]]) {
                        var temp = island[costs[i][1]]
                        for(a in island.indices) {
                            if(island[a]==temp) {
                                island[a]=island[costs[i][0]]
                            }
                        }
                        answer+=costs[i][2]
                    }
                    else if(island[costs[i][0]]>island[costs[i][1]]) {
                        var temp = island[costs[i][0]]
                        for(a in island.indices) {
                            if(island[a]==temp) {
                                island[a]=island[costs[i][1]]
                            }
                        }
                        answer+=costs[i][2]
                    }
                }
              System.out.println("${i+1}번째 결과")
              for(a in island){
                  System.out.printf("%d/",a)
               }
               System.out.println()
               System.out.println("answer"+answer)
           }

        return answer
    }
}
